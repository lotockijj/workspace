from datetime import datetime
from app import app
import db

__author__ = 'Eugene Kondrashev'
__email__ = 'eugene.kondrashev@gmail.com'

import unittest
import json

class TestFlaskAPiSignIn(unittest.TestCase):

    def setUp(self):
        self.app = app.test_client()

    def test_signin_successfully_paid(self):
        response = self.app.get('/user/signin?mailaddr=toniafemale@gmail.com')
        self.assertEqual(json.loads(response.get_data()),
                         {u'email': u'toniafemale@gmail.com',
                          u'interests': [u'love', u'mind power'],
                          u'paid': True,
                          u'registered': True
                          })

class TestFlaskApiSignIn(unittest.TestCase):
    def setUp(self):
        self.app = app.test_client()
        # self.user = db.users.user()
        self.user = db.users.user(email='test@test.com', firstname='fn',
                                  lastname='ln', gender=True,
                                  desires='findLove / betterSex',
                                  reg_date=datetime.now(), is_customer=False)
        db.users.add(self.user)

    def tearDown(self):
        db.users.remove(self.user)


    def test_signin_successfuly(self):
        response = self.app.get('/user/signin?mailaddr=test@test.com')
        self.assertEqual(json.loads(response.get_data()),
                         {u'email': u'test@test.com',
                          u'interests': [u'findLove', u'betterSex'],
                          u'paid': False,
                          u'registered': True
                          })


class TestFlaskApiSignUp(unittest.TestCase):
    def setUp(self):
        self.app = app.test_client()
        self.user = db.users.user(email='test@test.com', firstname='fn',
                                  lastname='ln', gender=True,
                                  desires='findLove / betterSex',
                                  reg_date=datetime.now(), is_customer=False)

    def tearDown(self):
        db.users.remove_by_email('test@test.com')

    def test_signup_successfuly(self):
        response = self.app.post('/user/signup?mailaddr=test@test.com',
                                 data={
                                     u'firstname': 'fn', u'lastname': 'ln',
                                     u'email': u'test@test.com',
                                     u'findLove': True, u'betterSex': True,
                                     u'paid': False,
                                     u'male': True, u'female': False,
                                     u'registered': True})
        self.assertEqual(json.loads(response.get_data()), {u'success': u'User saved to DB'})
        response = self.app.get('/user/signin?mailaddr=test@test.com')
        self.assertEqual(json.loads(response.get_data()),
                         {u'email': u'test@test.com',
                          u'interests': [u'findLove', u'betterSex'],
                          u'paid': False,
                          u'registered': True})

        if __name__ == "__main__":
            unittest.main()
