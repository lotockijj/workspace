import unittest
import json

__author__ = 'Eugene Kondrashev'
__email__ = 'eugene.kondrashev@gmail.com'
from app import app

class TestFlaskApiSignIn(unittest.TestCase):
    def setUp(self):
        self.app = app.test_client()


    def test_payment_refund(self):
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

        response = self.app.post('/payment/refund?mailaddr=fake@fake.com')
        self.assertEqual(
            json.loads(response.get_data()),
            {u'success': u'payment refunded'})

        response = self.app.post('/payment/refund?mailaddr=fake@fake.com')
        self.assertEqual(
            json.loads(response.get_data()),
            {u'error': u'no such payment'})