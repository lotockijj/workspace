#Features:
* Script generates, maintains and monitors the tokens relevance, that required for authentication on the Gmail server on Oauth2 technology. All mail server authentication data is stored in the configuration file in the folder of the script.
* Get out of the mail server all unread messages and analyzes only those that meet the specified rules (compares matching specified masks the contents of fields from header of the message).
* Bot recognizes these types of messages: order, refund, payment cancellation and chargeback notifications.
* Pars each found on the specified masks message and gets a maximum of information: order number, order date, customer name, customer email, product, cost and currency.
* Processed only notifications concerning products containing the word "mindcastr" in its full title.
* All received data sending to server by Rest API. If an error occurs while sending, the data stored in the local json-file until the next transfer.
* All skipped by server refunds are saves in local file.
* Script provides the ability to send curl-requests instead of using urllib2.Request() method (actual for some free hostings).
* Script supports command line options.
* All events are logged in detail.
* Bot detects the presence of other running instances and it quits when finds them.

# Installation
For executing script requires an interpreter Python 2.6 or higher (Python 2.7.9 is recommended).
Run following command to install all required dependencies:
pip install -r requirements.txt

#How to run
Launch python script from terminal:
`python check_sales.py

# How simulate ClickBank notifications to testing the bot?
Here are the steps to simulate ClickBank notifications.
In the script it was added the possibility of ClickBank-messages analysis sent from the e-mail address "mindcastr.com@gmail.com".
For testing script work you should to create a message which will be an exact copy of one of ClickBank notifications.
And send this message to yourself: from "mindcastr.com@gmail.com" to "mindcastr.com@gmail.com".

Currently bot recognizes these types of notifications.
* Order:
Subject: CB RB Sale: SPIRO23-mc2trial #A8BBBQV9
* Refund:
Subject: ClickBank Recurring Billing Rebill Notification #2GNWLS6E-B003
* Cancellation:
Subject: ClickBank Cancellation Confirmation Order #QDTNAFWX-B002
* Chargeback:
Subject: ClickBank Chargeback Notification: mc2trial #J239LYTE

Step-by-step instruction:
1. Go to Gmail inbox of "mindcastr.com@gmail.com" and open one of the following ClickBank notifications.
2. Select option "Show original" in the right side of the window.
3. Open another Gmail window and create new message.
4. Fill in the fields as follows:
To: mindcastr.com@gmail.com
Subject: - copy value from the original message.
And copy message body from the original message also.
4.1. Save this mail as a template perhaps in order to reuse it in future.
5. Send this message.

Bot runs on the server every minute and checks new messages in the mailbox.
So you will see the changes in the database in a minute.
