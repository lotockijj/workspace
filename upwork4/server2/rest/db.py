import logging
from sqlalchemy import create_engine, exists, MetaData
from sqlalchemy.exc import DatabaseError
from sqlalchemy.ext.automap import automap_base
from sqlalchemy.ext.declarative import declarative_base
from sqlalchemy.orm import relationship, sessionmaker, scoped_session
from sqlalchemy.orm.exc import NoResultFound
from sqlalchemy.schema import Column, ForeignKey
from sqlalchemy.types import Integer, String
from sqlalchemy.engine.url import URL

logger = logging.getLogger(__name__)
logging.basicConfig(
    format=u'%(filename)s[LINE:%(lineno)d]# %(levelname)-8s [%(asctime)s]  %(message)s',
    level=logging.DEBUG)

DATABASE = {
    'drivername': 'mysql+pymysql',
    'host': '194.28.84.94',
    'port': '3306',
    'username': 'mindcast_user',
    'password': 'sdfLKsdf45fw',
    'database': 'mindcast_db'
}

engine = create_engine(URL(**DATABASE), convert_unicode=True)
metadata = MetaData()
session = scoped_session(sessionmaker(autocommit=False,
                                      autoflush=False,
                                      bind=engine))

Base = automap_base()

# reflect the tables
Base.prepare(engine, reflect=True)

class Users():
    def __init__(self, table, session):
        self.user = table
        self.session = session

    def _flush(self):
        try:
            self.session.flush()
        except DatabaseError:
            self.session.rollback()
            raise

    def remove_by_email(self, email):
        self.session.query(self.user).filter(self.user.email == email).delete()
        self._flush()

    def remove(self, user):
        self.session.delete(user)
        self._flush()

    def add(self, user):
        """
        Save user to database.
        :param user: Dictionary - {'email':'user_email', 'paid':'Boolean', 'loggedin':'Boolean'}
        """
        self.session.add(user)
        self._flush()

    def find_by_mail(self, email):
        """
        Find email in database.
        :param email: String email to find
        :return : PyMongo Cursor object
        """
        try:
            user = self.session.query(self.user).filter(
                self.user.email == email).one()
            return {
                'email': email,
                "interests": map(unicode.strip, user.desires.split('/')),
                "female": not user.gender,
                "male": user.gender,
                "lastname": user.lastname,
                "firstname": user.firstname
            }
        except NoResultFound:
            logger.debug('No user found for email %s', email)
            pass


class Payments():
    def __init__(self, table, session):
        self.payment = table
        self.session = session

    def _flush(self):
        try:
            self.session.flush()
        except DatabaseError:
            self.session.rollback()
            raise

    def remove_by_email(self, email):
        self.session.query(self.payment).filter(self.payment.email == email).delete()
        self._flush()

    def add(self, payment):
        """
        Save payment to database.
        :param payment: Dictionary - {"order": Integer,"date": String,
                                      "email": String, "name": String, "cost": Float,
                                      "currency": String}
        """
        if isinstance(payment, dict):
            args = payment
            args['_id'] = args['order']
            del args['order']
            payment = self.payment(**payment)
        self.session.add(payment)
        self._flush()

    def find_by_id(self, payment_id):
        """
        Find payment in database.
        :param payment_id: String payment id to find
        :return : Dictionary - {"order": Integer,"date": String,
                                "email": String, "name": String, "cost": Float,
                                "currency": String}
        """
        try:
            return self.session.query(self.payment).filter(
                self.payment._id == payment_id).one()
        except NoResultFound:
            pass

    def find_by_mail(self, email):
        """
        Find payment in database.
        :param email: String payment mail to find
        :return : Dictionary - {"order": Integer,"date": String,
                                "email": String, "name": String, "cost": Float,
                                "currency": String}
        """
        try:
            return self.session.query(self.payment).filter(
                self.payment.email == email).one()
        except NoResultFound:
            pass

    def refund(self, mail):
        try:
            return self.session.query(self.payment).filter(self.payment.email == mail).delete()
        except NoResultFound:
            pass


users = Users(Base.classes.users, session)
payments = Payments(Base.classes.payments, session)

#http://chase-seibert.github.io/blog/2016/03/31/flask-sqlalchemy-sessionless.html