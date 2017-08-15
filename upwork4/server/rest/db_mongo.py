"""
Implements connection to DB and some useful methods to work with DB.
"""

from pymongo import MongoClient
from settings import *
import logging
from datetime import datetime
import time

logger = logging.getLogger(__name__)
logging.basicConfig(format = u'%(filename)s[LINE:%(lineno)d]# %(levelname)-8s [%(asctime)s]  %(message)s', level = logging.DEBUG)

client = MongoClient(URL)

database = client[DB]


class Users():
    def __init__(self, table):
        self.collection = table

    def add(self, user):
        """
        Save user to database.
        :param user: Dictionary - {'email':'user_email', 'paid':'Boolean', 'loggedin':'Boolean'}
        """
        self.collection.save(user)

    def find_by_mail(self, mail):
        """
        Find email in database.
        :param mail: String email to find
        :return : PyMongo Cursor object
        """
        try:
            return next(iter(self.collection.find({"email": mail}).limit(1)))
        except StopIteration:
            logger.debug('No user found for email %s', mail)
            pass



class Payments():
    def __init__(self, table):
        self.collection = table

    def add(self, payment):
        """
        Save payment to database.
        :param payment: Dictionary - {"order": Integer,"date": String,
                                      "email": String, "name": String, "cost": Float,
                                      "currency": String}
        """
        self.collection.save(payment)

    def find_by_id(self, payment_id):
        """
        Find payment in database.
        :param payment_id: String payment id to find
        :return : Dictionary - {"order": Integer,"date": String,
                                "email": String, "name": String, "cost": Float,
                                "currency": String}
        """
        try:
            return next(iter(self.collection.find({"order": payment_id}).limit(1)))
        except StopIteration:
            pass

    def find_by_mail(self, payment_mail):
        """
        Find payment in database.
        :param payment_mail: String payment mail to find
        :return : Dictionary - {"order": Integer,"date": String,
                                "email": String, "name": String, "cost": Float,
                                "currency": String}
        """
        try:
            return next(iter(self.collection.find({"email": payment_mail}).limit(1)))
        except StopIteration:
            pass

    def refund(self, mail):
        return self.collection.delete_one({'email': mail}).deleted_count == 1


class Announcements():
    def __init__(self, table):
        self.collection = table

    def add(self, announce):
        """
        Save announce to database.
        :param announce: Dictionary - {"announce_id": String,"link": String,
                                      "message": String, "name": String, "date": datetime,
                                      }
        """
        self.collection.save(announce)

    def find_anounce_by_id(self, anounce_id):
        """
        Find announce in database.
        :param announce_id: String announce_id to find
        :return : Dictionary - {"announce_id": String,"link": String,
                                "message": String, "name": String, "date": datetime,
                                }
        """
        try:
            return next(
                iter(
                    self.collection.find(
                        {"anounce_id": anounce_id}
                    ).sort("_id", -1).limit(1)
                )
            )
        except StopIteration:
            pass

    def find_anounce_greater_date(self, anounce_date_from, anounce_date_till):
        """
        Find announce in database.
        :param anounce_date_from: String announce_date to find anounce with date greater than provided.
        :param anounce_date_till: String announce_date to find anounce with date lower than provided.
        :return : Dictionary - {"announce_id": String,"link": String,
                                "message": String, "name": String, "date": datetime,
                                }
        """
        print(anounce_date_from, anounce_date_till)
        try:
            return self.collection.find(
                    {"$and":
                    [
                        {"datefrom": {'$gte': int(anounce_date_from)}},
                        {"datetill": {'$lte': int(anounce_date_till)}}
                    ]
                    }
                    ).sort("date", 1)
        except StopIteration:
            pass

    def find_anounce_by_date(self, anounce_date):
        """
        Find announce in database.
        :param anounce_date: String announce_date to find anounce with date greater than provided. Date format - %Y-%m-%d %H:%M:%S
        :return : Dictionary - {"announce_id": String,"link": String,
                                "message": String, "name": String, "date": datetime,
                                }
        """
        try:
            return next(
                iter(
                    self.collection.find(
                        {"date": {'$eq': int(anounce_date)}}
                    ).sort("date", 1).limit(1)
                )
            )
        except StopIteration:
            pass
users = Users(database[USERS_TABLE])
payments = Payments(database[PAYMENT_TABLE])
announcements = Announcements(database[ANNOUNCE_TABLE])