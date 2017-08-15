#!/home/Atlas23/.virtualenvs/flask-webapp/bin/python2.7
# -*- coding:utf-8 -*-
import os, json, re, base64
from werkzeug import secure_filename
from flask import render_template, flash, redirect, session, url_for, request, g
from flask_login import login_user, logout_user, current_user, login_required
from app import app, lm, models
from forms import LoginForm, EditForm, ChangePassword
USERS = {}

@lm.user_loader
def load_user(id):
   return USERS.get(id)

@app.before_request
def before_request():
   g.user = current_user

@app.route('/login',methods=['GET','POST'])
def login():
   if g.user is not None and USERS.get(g.user.get_id())==g.user:
      return redirect(url_for('index'))
   form = LoginForm()
   if form.validate_on_submit():
      username = form.username.data
      password = form.password.data
      if username!=base64.b64decode(app.config['USERNAME']) or password!=base64.b64decode(app.config['PASSWORD']):
         flash('Username or Password is invalid' , 'error')
         return redirect(url_for('login'))
      user = models.User(username, password)
      login_user(user)
      g.user = current_user
      USERS[username] = user
      flash('Logged in successfully')
      return redirect(request.form.get('next') or url_for('index'))
   return render_template('login.html',
      next=request.args.get('next') or url_for('index'),
      title = 'Sign In', form = form)

@app.route('/logout')
def logout():
   logout_user()
   flash('Logged out successfully')
   return redirect(url_for('login'))

@app.route('/', methods=['GET','POST'])
@app.route('/index', methods=['GET','POST'])
@login_required
def index():
   with open(os.path.join(app.config['UPLOAD_FOLDER'], app.config['FILENAME']), 'r') as f:
      jdata = json.loads(f.read())
   form = EditForm()
   if form.validate_on_submit():
      imgfile1 = request.files['imagefile1']
      if imgfile1:
         name, ext = os.path.splitext(imgfile1.filename.lower())
         if ext[1:] in app.config['ALLOWED_IMAGE_EXTENSIONS']:
            imgfilename1 = secure_filename(imgfile1.filename)
            imgfile1.save(os.path.join(app.config['UPLOAD_FOLDER'], app.config['IMAGE1']))
            jdata['ads1']['img'] = request.url_root + app.config['IMAGE1']
         else:
            flash('Selected image file <{0}> is not allowed! (first image)'.format(imgfile1.filename), 'error')
      imgfile2 = request.files['imagefile2']
      if imgfile2:
         name, ext = os.path.splitext(imgfile2.filename.lower())
         if ext[1:] in app.config['ALLOWED_IMAGE_EXTENSIONS']:
            imgfilename2 = secure_filename(imgfile2.filename)
            imgfile2.save(os.path.join(app.config['UPLOAD_FOLDER'], app.config['IMAGE2']))
            jdata['ads2']['img'] = request.url_root + app.config['IMAGE2']
         else:
            flash('Selected image file <{0}> is not allowed! (second image)'.format(imgfile2.filename), 'error')
      upfile1 = request.files['updatefile1']
      if upfile1:
         name, ext = os.path.splitext(upfile1.filename.lower())
         if ext[1:] in app.config['ALLOWED_UPDATEFILE_EXTENSIONS']:
            upfilename1 = secure_filename(upfile1.filename)
            upfile1.save(os.path.join(app.config['UPLOAD_FOLDER'], app.config['UPDATE_FILE1']))
            jdata['latest_mindcastr_version']['update_files']['win'] = request.url_root + app.config['UPDATE_FILE1']
         else:
            flash('Selected update file <{0}> is not allowed! (Win update file)'.format(upfile1.filename), 'error')
      upfile2 = request.files['updatefile2']
      if upfile2:
         name, ext = os.path.splitext(upfile2.filename.lower())
         if ext[1:] in app.config['ALLOWED_UPDATEFILE_EXTENSIONS']:
            upfilename2 = secure_filename(upfile2.filename)
            upfile2.save(os.path.join(app.config['UPLOAD_FOLDER'], app.config['UPDATE_FILE2']))
            jdata['latest_mindcastr_version']['update_files']['mac'] = request.url_root + app.config['UPDATE_FILE2']
         else:
            flash('Selected update file <{0}> is not allowed! (Mac update file)'.format(upfile2.filename), 'error')
      if form.urladdr1.data:
         if re.match("^https?://.+$", form.urladdr1.data):
            jdata['ads1']['url'] = form.urladdr1.data
         else:
            flash('String <' + form.urladdr1.data + '> is not URL! (in first url)', 'error')
      if form.urladdr2.data:
         if re.match("^https?://.+$", form.urladdr2.data):
            jdata['ads2']['url'] = form.urladdr2.data
         else:
            flash('String <' + form.urladdr2.data + '> is not URL! (in second url)', 'error')
      if form.latest_url.data:
         if re.match("^https?://.+$", form.latest_url.data):
            jdata['latest_mindcastr_version']['url'] = form.latest_url.data
         else:
            flash('String <' + form.latest_url.data + '> is not URL! (in latest version)', 'error')
      if form.version.data:
         jdata['latest_mindcastr_version']['version'] = form.version.data
      if form.tutorial_url.data:
         if re.match("^https?://.+$", form.tutorial_url.data):
            jdata['tutorialUrl'] = form.tutorial_url.data
         else:
            flash('String <' + form.tutorial_url.data + '> is not URL! (in tutorial url)', 'error')

      with open(os.path.join(app.config['UPLOAD_FOLDER'], app.config['FILENAME']), 'w') as f:
         f.write(json.dumps(jdata, sort_keys=True, indent=4))
         flash('Your changes have been saved.')
      return redirect(url_for('index'))
   return render_template("index.html",
      title = 'Config Editor', form = form, data = jdata)

@app.route('/pwd',methods=['GET','POST'])
@login_required
def change_pwd():
   form = ChangePassword()
   if form.validate_on_submit():
      if form.curpwd.data==base64.b64decode(app.config['PASSWORD']):
         if form.password1.data==form.password2.data:
            s = 'USERNAME = "{}"\nPASSWORD = "{}"'.format(base64.b64encode(form.username.data), base64.b64encode(form.password1.data))
            with open('auth.py', 'w') as f:
               f.write(s)
            if form.username.data!=base64.b64decode(app.config['USERNAME']):
               flash('New username have been saved.')
               app.config['USERNAME']=base64.b64encode(form.username.data)
            if form.curpwd.data!=form.password1.data:
               flash('Password was changed succesfully.')
               app.config['PASSWORD']=base64.b64encode(form.password1.data)
            logout_user()
         else:
            flash('Introduced a different passwords', 'error')
      else:
         flash('Entered an incorrect current password.', 'error')
      return redirect(url_for('change_pwd'))
   return render_template("password.html",
      title = 'Change password', form = form, username=base64.b64decode(app.config['USERNAME']))
