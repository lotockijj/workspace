#!/usr/bin/python
#-*- coding:utf-8 -*-
import imaplib, email
from email.header import decode_header
from oauth2 import RefreshToken, GenerateOAuth2String, curl_request
from datetime import datetime
from urllib2 import build_opener, Request, HTTPHandler, HTTPError
import sys, os, time, re, json
import argparse, logging
from logging.handlers import RotatingFileHandler
from ConfigParser import ConfigParser
from tempfile import gettempdir

def get_log_handler(log_file, level=logging.DEBUG):
    """ Create Handler for logging object """
    logger.setLevel(level)
    log_formatter = logging.Formatter('%(asctime)s - %(message)s', datefmt='%Y.%m.%d %H:%M:%S')
    log_handler = RotatingFileHandler(log_file, maxBytes=409600, backupCount=3)
    log_handler.setFormatter(log_formatter)
    return log_handler

logger = logging.getLogger(__name__)
logger.addHandler(get_log_handler(os.path.join(sys.path[0], r'check_sales.log'), logging.DEBUG))

parser = argparse.ArgumentParser(add_help=True)
parser.add_argument('-c', '--config', dest='conf_filename', action='store',
    nargs='?', required=False, default=r'check_sales.conf',
    help='Set configuration filename')
parser.add_argument('-o', '--output', dest='db_filename', action='store',
    nargs='?', required=False, default=r'check_sales.json',
    help='Set output filename')

class Oauth(object):
    """ Oauth2 authentication object """
    def __init__(self, conf_file):
        config = ConfigParser()
        config.read(conf_file)
        self.filename = conf_file
        self.server = config.get('auth', 'imap_server')
        self.user = config.get('auth', 'username')
        self.client_id = config.get('auth', 'client_id')
        self.client_secret = config.get('auth', 'client_secret')
        self.refresh_token = config.get('auth', 'refresh_token')
        self.access_token = config.get('auth', 'access_token')
        self.expires_at = config.getint('auth', 'expires_at')
        self.oauth2_string = config.get('auth', 'oauth2_string')

    def is_expired(self):
        """ Check Oauth2 string relevance """
        return self.expires_at <= int(time.mktime(datetime.now().timetuple()))

    def refresh(self):
        """ Get new Access Token and Oauth2 String """
        response = RefreshToken(self.client_id, self.client_secret, self.refresh_token)
        if 'error' in response:
            logger.error("An error '%s' occurred while updating access token", response.get('error'))
            return False
        new_access_token = response['access_token']
        new_expires_at = int(time.mktime(datetime.now().timetuple())) + response['expires_in'] - 50
        new_oauth2_string = GenerateOAuth2String(self.user, new_access_token, base64_encode=False)

        config = ConfigParser()
        config.read(self.filename)
        config.set('auth', 'access_token', new_access_token)
        config.set('auth', 'expires_at', new_expires_at)
        config.set('auth', 'oauth2_string', new_oauth2_string)
        try:
            with open(self.filename, 'w') as fp:
                config.write(fp)
        except:
            logger.exception('Failed to save new access token')
            return False
        self.access_token = new_access_token
        self.expires_at = new_expires_at
        self.oauth2_string = new_oauth2_string
        logger.info('Configuration file has been successfully updated')
        return True

class Pid(object):
    def __init__(self, filename):
        self.file = filename
    def lock(self):
        try:
            with open(self.file, 'w') as f:
                f.write(' ')
        except:
            return False
        return True
    def unlock(self):
        try:
            os.remove(self.file)
        except:
            return False
        return True
    def locked(self):
        return os.path.exists(self.file) and os.path.isfile(self.file)

def head_to_decode_string(some_header):
    """ Decode email header and join it to string """
    return ' '.join([dh[0].decode(dh[1]) if dh[1] else dh[0] for dh in decode_header(some_header)])

def get_decoded_email_body(msg, html=False):
    """ Decode email body.
    Detect character set if the header is not set.
    :param msg: Raw 7-bit message body input e.g. from imaplib. Double encoded in quoted-printable and latin-1
    :return: Message body as unicode string
    """
    result, text = None, None
    if msg.is_multipart():
        html = None
        for part in msg.get_payload():
            if part.get_content_charset() is None:
                # Script cannot know the character set, so return decoded "something"
                text = part.get_payload(decode=True)
                continue
            charset = part.get_content_charset()
            if part.get_content_type() == 'text/plain':
                text = unicode(part.get_payload(decode=True), str(charset), "ignore").encode('utf8', 'replace')
            if part.get_content_type() == 'text/html':
                html = unicode(part.get_payload(decode=True), str(charset), "ignore").encode('utf8', 'replace')
        result = html.strip() if html else\
            text.strip() if text is not None else html.strip()
    else:	# if not msg.is_multipart()
        result = unicode(msg.get_payload(decode=True), msg.get_content_charset(), 'ignore').encode('utf8', 'replace').strip()
    return result

def is_payment_notification(message):
    """ Verification of compliance messages to specified rules """
    rules = {
        'order': {
            'From': r"^.*noreply@clickbank\.com.?$",
            'To': r"^.*mindcastr\.com@gmail\.com.?$",
            'Return-Path': r"^.*noreply@clickbank\.com.?$",
            'Subject': r"^.*CB.+Sale:\s+SPIRO23-(?P<product>\S+)\s+#\w+.*$"
        },
        'refund': {    # Refund Notification
            'From': r"^.*noreply@clickbank\.com.?$",
            'To': r"^.*mindcastr\.com@gmail\.com.?$",
            'Return-Path': r"^.*noreply@clickbank\.com.?$",
            'Subject': r"^.*ClickBank\s+Refund\s+Confirmation\s+Order\s+#\w+.*$"
        },
        'refund_cncl': {    # Cancellation Notification
            'From': r"^.*noreply@clickbank\.com.?$",
            'To': r"^.*mindcastr\.com@gmail\.com.?$",
            'Return-Path': r"^.*noreply@clickbank\.com.?$",
            'Subject': r"^.*ClickBank\s+Cancellation\s+Confirmation\s+Order\s+#\w+.*$"
        },
        'refund_sb': {    # Subscription Cancellation Notification
            'From': r"^.*noreply@clickbank\.com.?$",
            'To': r"^.*mindcastr\.com@gmail\.com.?$",
            'Return-Path': r"^.*noreply@clickbank\.com.?$",
            'Subject': r"^.*ClickBank\s+Subscription\s+Cancellation\s+Notification\s+\w+.*$"
        },
        'refund_cb': {    # Chargeback Notification
            'From': r"^.*noreply@clickbank\.com.?$",
            'To': r"^.*mindcastr\.com@gmail\.com.?$",
            'Return-Path': r"^.*noreply@clickbank\.com.?$",
            'Subject': r"^.*ClickBank\s+Chargeback\s+Notification:\s+(?P<product>\S+)\s+#\w+.*$"
        }
    }
    backdoor_rules = {}
    for type in rules:
        backdoor_rules[type] = {
            'From': r"^.*mindcastr\.com@gmail\.com.?$",
            'To': rules.get(type).get('To'),
            'Subject': rules.get(type).get('Subject')
        }
    is_accordance_with = lambda type, rules, message:\
        not next(((field, pattern) for field, pattern in rules.get(type).items()\
            if not re.match(pattern, head_to_decode_string(message[field]))), None)
    for type in rules:
        if is_accordance_with(type, rules, message)\
            or is_accordance_with(type, backdoor_rules, message):
            product_match = re.match(rules.get(type).get('Subject'), head_to_decode_string(message.get('Subject')))
            product_id = product_match.group('product') if product_match.groups() else ''
            return (type, product_id)
    return ('', '')

def get_payment_notifications(mail):
    """ Get a list of useful messages about payments """
    notifications, counters = [], {}
    resp = filter(lambda ret: ret[0]=='OK', [mail.search(None, '(UNSEEN)')])[0]
    msg_ids = resp[1][0].split() if resp[1][0] else []
    logger.info('Available %d unread messages', len(msg_ids))
    for num in msg_ids: # iteration unread messages ID's
        typ, data = mail.fetch(num,'(RFC822)')
        resp = filter(lambda rp: isinstance(rp, tuple), data)
        msg = email.message_from_string(resp[0][1])
        notification_type, product_id = is_payment_notification(msg)
        if notification_type:
            notifications.append((notification_type, product_id, msg))
            counters[notification_type] = counters.get(notification_type, 0) + 1
        typ, data = mail.store(num,'+FLAGS','\\Seen')
    logger.info('%d notifications from bank was found: %s', len(notifications), counters)
    return notifications

def parse_cost(price):
    """ Separates field values <cost> and <currency> """
    try:
        cost = re.search("[0-9\.\,]+", price).group() if price else ''
    except:
        logger.warning('Incorrect cost and currency format: %s', price)
        cost = price
    return cost, ''.join(price.strip().split(cost)).strip()

def get_sale_data((type, product_id, message)):
    """ Receiving payment data from a message """
    result = {}
    html = re.sub(r"https?://.*/", '', get_decoded_email_body(message, html=True))
    keywords = ['mc2', 'mindcastr', 'mind castr']
    ids_list = ['mc2', 'mc2trial']
    if not next((word for word in keywords if word in html.lower()), None)\
        and (type=='refund_cb' and product_id.lower() not in ids_list)\
        or not html.strip():
        return result
    patterns = {
        'order': r"Order\s+#:\s*(?P<order>[^\r\n<]+).+?" +\
            r"Placed\s+(?P<date>[^\r\n]+).+?" +\
            r"<h3>(?P<product>[^\r\n<>]+)</h3>.+?" +\
            r"Price:.+align=\"right\">[\r\n\s]+(?P<price>[^\r\n]+).+?" +\
            r"BILLING INFO.+<td>[\r\n\s]+(?P<name>[^\r\n]+)[\r\n\s]+</td>.+?" +\
            r"<a href=\"mailto:(?P<email>[^\"]+).+",
    'refund': r"Order Number:.+\"top\">[\r\n\s]*(?P<order>[^\r\n<]+).+" +\
        r"Order Date:.+\"top\">[\r\n\s]*(?P<date>[^\r\n<]+).+" +\
        r"Customer Name:.+\"top\">[\r\n\s]*(?P<name>[^\r\n<]+).+" +\
        r"Customer Email:.+\"top\">[\r\n\s]*(<.+>)?(?P<email>[^\r\n<]+).+" +\
        r"Product:.+\"top\">[\r\n\s]*(?P<product>[^\r\n<]+).+" +\
        r"Product ID:.+" +\
        r"Total:.+\"top\">[\r\n\s]*(?P<price>[^\r\n<]+)[\r\n\s]+</td>",
    'refund_cncl': r"Order Number:.+\"top\">[\r\n\s]*(?P<order>[^\r\n<]+).+" +\
        r"Order Date:.+\"top\">[\r\n\s]*(?P<date>[^\r\n<]+).+" +\
        r"Customer Name:.+\"top\">[\r\n\s]*(?P<name>[^\r\n<]+).+" +\
        r"Customer Email:.+\"top\">[\r\n\s]*(<.+>)?(?P<email>[^\r\n<]+).+" +\
        r"Product:.+\"top\">[\r\n\s]*(?P<product>[^\r\n<]+).+" +\
        r"Product ID:.+" +\
        r"Total:.+\"top\">[\r\n\s]*(?P<price>[^\r\n<]+)[\r\n\s]+</td>.+" +\
        r"Future Payments:",
    'refund_sb': r"Order Number:.+\"top\">[\r\n\s]*(?P<order>[^\r\n<]+).+" +\
        r"Order Date:.+\"top\">[\r\n\s]*(?P<date>[^\r\n<]+).+" +\
        r"Customer Name:.+\"top\">[\r\n\s]*(?P<name>[^\r\n<]+).+" +\
        r"Customer Email:.+\"top\">[\r\n\s]*(<.+>)?(?P<email>[^\r\n<]+).+" +\
        r"Product:.+\"top\">[\r\n\s]*(?P<product>[^\r\n<]+).+" +\
        r"Product ID:.+" +\
        r"Product Type:(?P<price>\s?)",
    'refund_cb': r"Order Number:.+\"top\">[\r\n\s]*(?P<order>[^\r\n<]+).+" +\
        r"Order Date:.+\"top\">[\r\n\s]*(?P<date>[^\r\n<]+).+" +\
        r"Customer Name:.+\"top\">[\r\n\s]*(?P<name>[^\r\n<]+).+" +\
        r"Customer Email:.+\"top\">[\r\n\s]*(<.+>)?(?P<email>[^\r\n<]+).+" +\
        r"Vendor.+s Site:(?P<product>\s*)</td>.+" +\
        r"Total:.+\"top\">[\r\n\s]*(?P<price>[^\r\n<]+)[\r\n\s]+</td>.+" +\
        r"Future Payments:"
    }
    object = re.compile(patterns.get(type), re.M | re.S | re.U)
    matches = object.search(html)
    if matches and len(matches.groups())>5:
        posix_time = ' '.join(matches.group('date').split(' ')[:3])
        try:
            posix_time = int(time.mktime(
                datetime.strptime(posix_time.strip(),\
                    "%B %d, %Y" if type[:3]!='ref' else "%m/%d/%Y %I:%M %p" ).timetuple()))
        except:
            logger.error('Incorrect date and time format: %s', matches.group('date'))
        result = {
            'type': type,
            'order': matches.group('order'),
            'date': posix_time,
            'name': matches.group('name'),
            'email': matches.group('email')
        }
        result['cost'], result['currency'] = parse_cost(matches.group('price'))
        if type=='refund_cb': # Product ID in Subject of message
           result['product'] = 'MindCastr' if product_id.lower() in ids_list else ''
        else:   # Product ID in message body
            result['product'] = matches.group('product')
    else:
        logger.error('Incorrect ordering message format: %s, %s', matches.groups() if matches else None, type)
    return result

def send_order(url, order, refunds=[]):
    """ Sends the order data to the server and returns operation status """
    param, header, response = '', '', {}
    data = dict(order)
    if data.get('type')[:3]=='ref':
        param = data.get('email')
    else:
        data.pop('type')
        header = 'application/json; charset=utf-8'
    data = json.dumps(data, ensure_ascii=False)
    try:
        opener = build_opener(HTTPHandler)
        req = Request(url + param, data)
        if header:
            req.add_header('Content-Type', header)
        req.get_method = lambda: 'POST'
        response = json.loads(opener.open(req).read().decode('utf-8'))
        #response = json.loads(curl_request(url, json.dumps(data), True).decode('utf-8'))
        logger.info('Sending: %s', order)
    except:
        logger.exception('Encountered an Error!')
        return False
    # Response processing
    if response.get('success'):
        return True
    elif response.get('error'):
        logger.error('%s - %s', response.get('error'), order)
        if order.get('type')[:3]=='ref':
            refunds.append(param)
            return True
    else:
        logger.error('Incorrect response: %s', response)
    return False


def if_mindcastr(product):
    product = product.lower()
    for marker in ('mc2', 'mindcastr', 'mind castr'):
        if marker in product:
            return True
    return False

SERVER = 'http://optafy.com:5000'
def send_all_orders(db_file, messages):
    """ Sends all orders to the server and process received response """
    urls = {
        'order': r'%s/payment/add' % SERVER,
        'refund': r'%s/payment/refund?mailaddr=' % SERVER,
        'refund_cncl': r'%s/payment/refund?mailaddr=' % SERVER,
        'refund_sb': r'%s/payment/refund?mailaddr=' % SERVER,
        'refund_cb': r'%s/payment/refund?mailaddr=' % SERVER
    }
    refunds_db = os.path.join(sys.path[0], 'refunds.json')
    orders, refunds, waiting_orders = [], [], []
    try:
        with open(db_file, 'r') as f:
            orders = json.loads(f.read())
    except:
        logger.warning("Can't open waiting orders database file: '%s'", db_file)
    if orders:
        logger.info('%d waiting orders was found', len(orders))
    for msg in messages:
        sale = get_sale_data(msg)
        if sale and not next((x for x in orders \
            if sale.get('date')==x.get('date') and sale.get('email')==x.get('email') \
            and sale.get('order')==x.get('order') and sale.get('type')==x.get('type') \
            and sale.get('cost')==x.get('cost')), None):
            orders.append(sale)
    counters = {}
    select_orders = lambda x: x.get('type')[:3]!='ref' and if_mindcastr(x.get('product'))
    select_refunds = lambda x: x.get('type')[:3]=='ref' and if_mindcastr(x.get('product'))
    for order in filter(select_orders, orders) + filter(select_refunds, orders):
        if send_order(urls.get(order.get('type')), order, refunds):
            counters['all'] = counters.get('all', 0) + 1
            counters[order.get('type')] = counters.get(order.get('type'), 0) + 1
        else:
            waiting_orders.append(order)
    try: # Storing waiting orders information
        with open(db_file, 'w') as f:
            f.write(json.dumps(waiting_orders, sort_keys=True, ensure_ascii=False, indent=4))
    except:
        logger.exception('Failed to save waiting orders information')
    if waiting_orders:
        logger.info('%d waiting orders was saved in "%s"', len(waiting_orders), db_file)
    if refunds:
        refunds = list(set(refunds))
        logger.info('%d refunds was skipped by server', len(refunds))
        try:
            refunds.extend(json.loads(open(refunds_db, 'r').read()))
        except:
            logger.warning("Can't read refunds database file: '%s'", refunds_db)
        refunds = list(set(refunds))
        try:
            with open(refunds_db, 'w') as fr:
                fr.write(json.dumps(refunds, sort_keys=True, ensure_ascii=False, indent=4))
        except:
            logger.warning("Can't open refunds database file: '%s'", refunds_db)
    logger.info('%d orders was sent to server: %s', counters.get('all', 0), counters)

def fetch_mail(conf_file, db_file):
    """ Obtaining and analyzing email messages """
    auth = Oauth(os.path.join(sys.path[0], conf_file))
    if auth.is_expired() and not auth.refresh():
        return
    mail = imaplib.IMAP4_SSL(auth.server)
    mail.authenticate('XOAUTH2', lambda x: auth.oauth2_string)
    mail.list()
    mail.select()
    messages = get_payment_notifications(mail)
    send_all_orders(os.path.join(sys.path[0], db_file), messages)

if __name__ == '__main__':
    pid = Pid(os.path.join(gettempdir(), 'clickbank_bot.pid'))
    if not pid.locked():
        try:
            pid.lock()
            args = parser.parse_args()
            fetch_mail(args.conf_filename, args.db_filename)
        finally:
            pid.unlock()