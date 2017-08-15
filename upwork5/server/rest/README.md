# Intro
The purpose of this application is to provide REST interface for the Membership feature. Clickbank bot is using this server in order to add/refund payments, while java client is using it to get/save user information and distinguish if user is a member or not(payment available)

# How to install mongodb

## Install mongodb
Follwo the steps https://www.howtoforge.com/tutorial/install-mongodb-on-ubuntu-16.04/

## Create user
use mc2
db.createUser( { user: "mc2",
          pwd: "Success23",
          roles: [ {role: "readWrite", db: "mc2"}] } )

# Install dependencies
`pip install -r requirements.txt`

# Run dev

`python app.py`


# Run Prod

`/usr/bin/python /usr/local/bin/gunicorn -b 0.0.0.0:5000 app:app -c gunicorn.conf`