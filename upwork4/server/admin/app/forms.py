#!/home/Atlas23/.virtualenvs/flask-webapp/bin/python2.7
# -*- coding:utf-8 -*-
from flask_wtf import Form
from wtforms import TextField, PasswordField, BooleanField, FileField
from wtforms.validators import Required

class LoginForm(Form):
   username = TextField('username', validators = [Required()])
   password = PasswordField('password', validators = [Required()])

class EditForm(Form):
   urladdr1 = TextField('urladdr1', validators = [Required()])
   imagefile1 = FileField('imagefile1')
   updatefile1 = FileField('updatefile1')
   urladdr2 = TextField('urladdr2', validators = [Required()])
   imagefile2 = FileField('imagefile2')
   updatefile2 = FileField('updatefile2')
   latest_url = TextField('latest_url', validators = [Required()])
   version = TextField('version', validators = [Required()])
   tutorial_url = TextField('tutorial_url', validators = [Required()])

class ChangePassword(Form):
   username = TextField('username', validators = [Required()])
   curpwd = PasswordField('current_password', validators = [Required()])
   password1 = PasswordField('password1', validators = [Required()])
   password2 = PasswordField('password2', validators = [Required()])

class AnounceForm(Form):
   button_text = TextField('button_text', validators = [Required()])
   anounce_text = TextField('anounce_text', validators = [Required()])
   anounce_link = TextField('anounce_link', validators = [Required()])
