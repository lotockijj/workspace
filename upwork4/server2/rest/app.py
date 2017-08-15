from datetime import datetime
import db
from flask import Flask, request, render_template
from flask_restful import Resource, Api
from sqlalchemy.exc import DatabaseError
from validate_email import validate_email
from db import users, payments
from forms import AnounceForm
import os 
import time


app = Flask(__name__)
# app.config['PRESERVE_CONTEXT_ON_EXCEPTION'] = True
api = Api(app)
app.secret_key = 's3cr3t'

def handle_error(f):
    def wrapper(*args, **kw):
        try:
            return f(*args, **kw)
        except Exception as e:
            return {'error': repr(e)}
    return wrapper


def mail_check(f):
    def wrapper(*args, **kw):
            email = request.values['mailaddr']
            if not validate_email(email):
                return {'error': "Not valid e-mail address"}
            else:
                args_ = list(args) + [email, ]
                return f(*args_, **kw)
    return wrapper


class SignInUser(Resource):
    @handle_error
    @mail_check
    def get(self, email):
        """
        Process get request to addr - /user/signin?mailaddr=<string:email_to_check>
        Example: localhost:5000/user/signin?mailaddr=11@aa.bb
        :return: Json object
        """
        user = users.find_by_mail(email)
        payment = payments.find_by_mail(email) is not None
        if user:
            return {'email': email, 'registered': True, 'paid': payment,
                    'interests': user['interests']}
        return {'error': 'User with this e-mail is not registered.'}

class SignUpUser(Resource):
    @handle_error
    @mail_check
    def post(self, email):
        """
        Process post request to addr - /user/signin?mailaddr=<string:email_to_check>
        Example: localhost:5000/user/signin?mailaddr=11@aa.bb
        :return: Json object
        """
        userdetails = users.find_by_mail(email)
        if userdetails:
            return {'error': 'User with this e-mail already registered.'}

        if (("findLove" in request.values or "toCureMyDiabetes" in request.values or
            "betterSex" in request.values or "toLoseWeight" in request.values or
            "lawOfAttractionMastery" in request.values or
                     "toBecomeRich" in request.values) and
                ("female" in request.values or "male" in request.values) and
                "firstname" in request.values and "lastname" in request.values):
            desires = []
            if 'findLove' in request.values:
                desires.append('findLove')
            if 'toCureMyDiabetes' in request.values:
                desires.append('toCureMyDiabetes')
            if 'betterSex' in request.values:
                desires.append('betterSex')
            if 'toLoseWeight' in request.values:
                desires.append('toLoseWeight')
            if 'lawOfAttractionMastery' in request.values:
                desires.append('lawOfAttractionMastery')
            if 'toBecomeRich' in request.values:
                desires.append('toBecomeRich')
            desires = ' / '.join(desires)
            user = users.user(email=request.values['email'], desires=desires,
                              firstname=request.values['firstname'], lastname=request.values['lastname'],
                              gender=request.values['male'] or request.values['female'],
                              reg_date=datetime.now(), is_customer=False)
            users.add(
                user
            )
            return {'success': 'User saved to DB'}
        return {'error': 'Not all fields are filled'}


class ProcessPayment(Resource):
    @handle_error
    def post(self):
        """
        Process post request to addr - /payment/add
        Example: localhost:5000/payment/add
        Extracts json object from request body. Request should be application/json type with a valid json inside.
        Example -{
                    "order": "TH2JL7VE",
                    "date": "08/09/2016 11:09 PM PDT",
                    "email": "nananamabunda@gmail.com",
                    "name": "Hebron S Zikhali",
                    "cost": "14.48",
                    "currency": "ZAR"
                }
        If save operations success.
        :return: Json object with operation result - {'status': 'Payment added to DB'}.
        If payment with this ID already exist in DB.
        :return: Json object with operation result - {'error': 'Payment exists in DB'}.
        If json not valid.
        :return: Json object with operation result - {"error": "<BadRequest '400: Bad Request'>"}.
        """
        json_object = request.get_json()
        if json_object is None:
            return {'error': 'Wrong Json format'}

        if payments.find_by_id(json_object['order']):
            return {'success': 'Payment exists in DB'}
        payments.add(json_object)
        return {'success': 'Payment added to DB user added to DB'}

class PaymentRefund(Resource):
    @handle_error
    @mail_check
    def post(self, email):
        """
        Process get request to addr - /payment/refund?mailaddr=<string:email_to_check>
        Example: localhost:5000/payment/refund?mailaddr=11@aa.bb
        :return: Json object
        """
        if payments.refund(email):
            return {'success': 'payment refunded'}
        return {'error': 'no such payment'}


class Announcements(Resource):
    @handle_error
    def post(self):
        """
        Process post request to addr - /announcements
        Example: localhost:5000/announcements
        Extracts json object from request body. Request should be application/json type with a valid json inside.
        Example - {"link": String,
                    "message": String, "name": String, "date": Integer,
                    }
                    ID will be autogenerated.
        CURL example:
            curl -X POST -H "Content-Type: application/json" -H "Cache-Control: no-cache" -d '{
            "link": "http:\\test",
            "message": "message1",
            "name": "name333",
            "date": 1477917837
            }' "http://localhost:5000/announcements"

        If save operations success.
        :return: Json object with operation result - {'success': 'Anounce added to DB'}.
        If payment with this ID already exist in DB.
        :return: Json object with operation result - {'success': 'Anounce exists in DB'}.
        If json not valid.
        :return: Json object with operation result - {'error': 'Wrong Json format'}.
        """
        try:
            json_object = request.get_json()
        except Exception as e:
            return {'error': 'Wrong Json format'}
        if json_object['datefrom'] and json_object['datetill']:
            print(json_object['datefrom'])
            print(json_object['datetill'])
            announcements.add(json_object)
            return {'success': 'Anounce added to DB'}
        return {'error':'Dates is mandatory fields'}

    @handle_error
    def get(self):
        """
        Process get request to addr - /announcements?anounce_date_from=<Anounce date>&anounce_date_till=<Anounce date>
        If success will return announce with date greater than anounce_date. Date format - Unix epoch time in second i.e - 1477917837
        Example - /announcements?anounce_date_from=1477917837&anounce_date_till=1477917837
        Returns: Dictionary - {"anounces": [                                ]}
        If failure:
        Returns: Dictionary - {'error': 'No such anounce_date in DB'}
        """
        anounce_date_from = request.values['anounce_date_from']
        anounce_date_till = request.values['anounce_date_till']
        anounces = announcements.find_anounce_greater_date(str(anounce_date_from), str(anounce_date_till))
        if anounces:
            ret = []
            for anounce in anounces:
                ret.append({"anounce_id": str(anounce.get('_id')), "link": anounce['link'], "message": anounce["message"], "name": anounce['name'], "datefrom": anounce["datefrom"], "datetill": anounce["datetill"]})
            return {"anounces" : ret}
        return {'error': 'No such anounce_date in DB'}


@app.route('/', methods = ['GET', 'POST'])
def index():
    form = AnounceForm()
    return render_template("post_announce.html", form = form)


api.add_resource(SignInUser, '/user/signin')
api.add_resource(SignUpUser, '/user/signup')
api.add_resource(PaymentRefund, '/payment/refund')
api.add_resource(ProcessPayment, '/payment/add')
api.add_resource(Announcements, '/announcements')


@app.after_request
def session_commit(response):
    if response.status_code >= 400:
        return response
    try:
        db.session.commit()
        return response
    except DatabaseError:
        db.session.rollback()
        raise


@app.teardown_request
def teardown_request(exception):
    if exception:
        db.session.rollback()
        # db.session.remove()
    db.session.remove()

if __name__ == '__main__':
    app.run(debug=True)
