#!/home/Atlas23/.virtualenvs/flask-webapp/bin/python2.7
# -*- coding:utf-8 -*-
from flask import Flask
app = Flask(__name__, template_folder='templates', static_folder='..', static_url_path='')
app.config.from_object('config')
app.config.from_object('auth')

from flask_login import LoginManager
lm = LoginManager()
lm.init_app(app)
lm.login_view = 'login'

from app import views
