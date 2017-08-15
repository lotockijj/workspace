# Intro
The purpose of this server is to provide interface for get/configure following information 
* latest version (see latest_mindcastr_version.txt)
* advertisement (jpg files)
* settings (mindcastr_settings.json)


# Install dependencies
`pip install -r requirements.txt`

# Run dev

`python app.py`


# Run Prod

`/usr/bin/python /usr/local/bin/gunicorn -b 0.0.0.0:8080 app:app -c gunicorn.conf`