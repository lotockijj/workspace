import json
import unittest
from app import app
from db import payments

__author__ = 'Eugene Kondrashev'
__email__ = 'eugene.kondrashev@gmail.com'


class TestFlaskApiSignUp(unittest.TestCase):
    def setUp(self):
        self.app = app.test_client()
        # payments.remove_by_email('fake@fake.com')

    def tearDown(self):
        payments.remove_by_email('fake@fake.com')

    def test_payment_wrong_json_format(self):
        response = self.app.post('/payment/add',
                                 data=''''''
                                 )
        self.assertEqual(
            json.loads(response.get_data()),
            {u'error': u'Wrong Json format'}
        )

    def test_payment_added(self):
        data = '''{"order": "TH2JL7VE",
                                       "date": "08/09/2016 11:09 PM PDT",
                                       "email": "fake@fake.com",
                                       "name": "Fake S",
                                       "cost": "14.48",
                                        "product": "TRY MINDCASTR FOR JUST $1",
                                       "currency": "ZAR"}'''
        response = self.app.post('/payment/add',
                                 data=data,
                                 content_type='application/json')
        self.assertEqual(
            json.loads(response.get_data()),
            {u'success': u'Payment added to DB user added to DB'}
        )
        response = self.app.post('/payment/add',
                                 data=data,
                                 content_type='application/json')
        self.assertEqual(
            json.loads(response.get_data()),
            {u'success': u'Payment exists in DB'}
        )
