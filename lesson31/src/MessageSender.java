

import javax.jms.*;
import javax.naming.*;

public class MessageSender {

	void sendMessage(String messageToSend){
		Session session = null;
		ConnectionFactory factory = null;
		Connection connection = null;
		try{
			//Find the JNDI context
			Context jndiContext = new InitialContext();
			//Look up the factory and the queue
			factory = (ConnectionFactory) jndiContext.lookup("MyTestConnectionFactory");
			Queue ioQueue = (Queue) jndiContext.lookup("MyJMSTestQueue");
			connection = factory.createConnection();
			connection.start();
			session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			MessageProducer queueSender = session.createProducer(ioQueue);
			//Buy 200 shares of IBM in this example
			TextMessage outMsg = session.createTextMessage(messageToSend);
			queueSender.send(outMsg);
			queueSender.close();
			System.out.println("Successfully placed an order to purchase 200 shares of IBM");
		} catch(JMSException e){
			System.out.println("Error: " + e.getMessage());
		} catch (NamingException e){
			e.printStackTrace();
		} finally{
			try{
				session.close();
				connection.close();
			} catch (Exception e){
				System.out.println("Can't close JMS connection/session " + e.getMessage());
			}
		}
	}
}