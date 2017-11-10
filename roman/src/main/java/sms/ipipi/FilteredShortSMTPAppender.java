package sms.ipipi;

import org.apache.log4j.spi.LoggingEvent;
import org.apache.log4j.helpers.LogLog;
import java.util.Date;
import javax.mail.Multipart;
import javax.mail.Transport;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeBodyPart;

public class FilteredShortSMTPAppender extends BaseFilteredSMTPAppender{

	@Override
	public void activateOptions(){
		super.activateOptions();
		setBufferSize(1);
	}

	@Override
	protected void sendBuffer() {
		cleanTimedoutExceptions();
		if (isSendMailAllowed()) {
			try {
				MimeBodyPart part = new MimeBodyPart();
				StringBuffer sbuf = new StringBuffer();
				String t = layout.getHeader();
				if (t != null) {
					sbuf.append(t);
				}
				LoggingEvent event = cb.get();
				sbuf.append(layout.format(event));
				if (layout.ignoresThrowable()) {
					String[] s = event.getThrowableStrRep();
					if (s != null && s.length > 0) {
						sbuf.append(s[0]);
					}
					t = layout.getFooter();
				}
				if (t != null) {
					sbuf.append(t);
				}
				part.setContent(sbuf.toString(), layout.getContentType());
				Multipart mp = new MimeMultipart();
				mp.addBodyPart(part);
				msg.setContent(mp);
				msg.setSentDate(new Date());
				Transport.send(msg);
				addException();
			}
			catch (Exception e) {
				LogLog.error("Error occured while sending e-mail notification.", e);
			}
		}
	}
}