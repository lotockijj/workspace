package yakov.fain.lesson19;

import java.io.*;
import java.text.*;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;

public class Mailer {
	private Session session = null;
	private static String emailSenderAddress = "yfain11@yahoo.com";
	private static String emailSubject = "Happy Birthday!!!";
	private String emailText = "Happy birthday dear %s!!!";
	ArrayList<String> friends = new ArrayList<String>();
	Mailer() {
		Properties sessionProperties = new Properties();
		sessionProperties.put("mail.smtp.host", "smtp.mail.yahoo.com");
		sessionProperties.put("mail.smtp.user", emailSenderAddress);
		sessionProperties.put("mail.smtp.port", "25");
		sessionProperties.put("mail.smtp.auth", "true");
		MyMailAuthenticator authentificatorForMessage =
				new MyMailAuthenticator();
		session = Session.getInstance(sessionProperties,
				authentificatorForMessage);
	}
	private void setPropsAndSendEmail(String emailRecipient, String emailText){
		try{
			Message emailMessage = new MimeMessage(session);
			emailMessage.setFrom(new InternetAddress(emailSenderAddress));
			emailMessage.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(emailRecipient, false));
			emailMessage.setSubject(emailSubject);
			emailMessage.setSentDate(new Date());
			emailMessage.setText(emailText);
			Transport.send(emailMessage);
			System.out.println("Your email to " + emailRecipient +
					" has been sent successfully");
		}catch(Exception e){
			System.out.println("Your email to " + emailRecipient +
					" has not been sent: " + e.getMessage());
			e.printStackTrace();
		}
	}
	private void readBirthdayFile() throws IOException {
		FileInputStream birthdayFile = new FileInputStream("birthday.txt");
		BufferedReader birthdayFileReader = new BufferedReader(
				new InputStreamReader(birthdayFile));
		String friendInfo;
		while ((friendInfo = birthdayFileReader.readLine()) != null){
			friends.add(friendInfo);
		}
		birthdayFileReader.close();
		birthdayFile.close();
	}
	private void iterateThroughBirthdays(){
		Iterator<String> iterator = friends.iterator();
		while (iterator.hasNext()){
			scanForManInfoAndSendEmail(iterator.next());
		}
	}
	private void scanForManInfoAndSendEmail(String stringFromArray){
		Scanner scannerOfLines = new Scanner(stringFromArray).useDelimiter("[,\n]");
		if (scannerOfLines.next().equals(getCurrentDateMMMd())) {
			String emailAddressee = scannerOfLines.next();
			String emailAddress = scannerOfLines.next();
			setPropsAndSendEmail(emailAddress,
					String.format(emailText, emailAddressee));
		}
	}
	private static String getCurrentDateMMMd(){
		return new SimpleDateFormat("MMM-d", Locale.US).format(new
				GregorianCalendar().getTime());
	}
	public static void main(String[] args){
		Mailer mm = new Mailer();
		try {
			mm.readBirthdayFile();
			mm.iterateThroughBirthdays();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}