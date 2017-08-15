#!/home/Atlas23/.virtualenvs/flask-webapp/bin/python2.7
from flask_login import UserMixin

class User(UserMixin):
   def __init__(self, username, password):
      self.id = username
      self.password = password

   @property
   def is_authenticated(self):
      return True

   def is_active(self):
      return True

   def is_anonymous(self):
      return False

   def get_id(self):
      return unicode(self.id)

   def __repr__(self):
      return '<User %r>' % (self.username)
