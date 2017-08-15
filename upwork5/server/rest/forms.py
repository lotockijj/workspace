#!/home/grisov/.virtualenvs/flask-webapp/bin/python2.7
# -*- coding:utf-8 -*-
from flask.ext.wtf import Form
from wtforms import TextField, PasswordField, BooleanField, FileField, DateField
from wtforms.validators import Required

class AnounceForm(Form):
   name = TextField('name', validators = [Required()])
   message = TextField('message', validators = [Required()])
   link = TextField('link', validators = [Required()])
   datefrom = DateField('datefrom', validators = [Required()])
   datetill = DateField('datetill', validators = [Required()])
