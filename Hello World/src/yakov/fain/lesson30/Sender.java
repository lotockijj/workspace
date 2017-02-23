package yakov.fain.lesson30;

import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.TextMessage;
import com.sun.messaging.ConnectionConfiguration;
import com.sun.messaging.ConnectionFactory;
import com.sun.messaging.Queue;
import com.sun.messaging.jms.Session;

public class Sender {

	public static void main(String[] args) {

		Session session=null;
		ConnectionFactory factory;
		javax.jms.QueueConnection connection=null;
		try{
			//The next two lines are specific to Open MQ. Another MOM
			// provider will have their own version of creating connection
			factory = new com.sun.messaging.ConnectionFactory();
			factory.setProperty(ConnectionConfiguration.imqAddressList,
					"mq://localhost:7677,mq://localhost:7677");
			connection = factory.createQueueConnection("admin","admin");
			connection.start();
			session = (Session) connection.createQueueSession(
					false, Session.AUTO_ACKNOWLEDGE);
			javax.jms.Queue ioQueue = session.createQueue("TestQueue");
			MessageProducer queueSender = session.createProducer(ioQueue);
			// Buy 200 shares of IBM at market price
			TextMessage outMsg = session.createTextMessage("IBM 200 Mkt");
			queueSender.send(outMsg);
			queueSender.close();
			System.out.println(
					"Successfully placed an order to purchase 200 shares of IBM");
		}
		catch (JMSException e){
			System.out.println("Error: " + e.getMessage());
		}
		finally{
			try{
				session.close();
				connection.close();
			} catch (Exception e) {
				System.out.println("Can’t close JMS connection/session " +
						e.getMessage());
			}
		}
	}

}
