package yakov.fain.lesson19;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

class MyMailAuthenticator extends Authenticator {
	
	protected PasswordAuthentication getPasswordAuthentication() {
		return new PasswordAuthentication ("test@yahoo.com", "password123");
	}
}