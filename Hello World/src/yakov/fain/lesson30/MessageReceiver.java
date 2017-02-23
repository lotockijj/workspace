package yakov.fain.lesson30;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import com.sun.messaging.ConnectionConfiguration;
import com.sun.messaging.ConnectionFactory;
import com.sun.messaging.Queue;
import com.sun.messaging.jms.QueueConnection;
import com.sun.messaging.jms.Session;

public class MessageReceiver implements MessageListener{
	Session session=null;
	ConnectionFactory factory;
	QueueConnection connection=null;
	MessageConsumer consumer=null;
	MessageReceiver(){
		try{
			factory = new com.sun.messaging.ConnectionFactory();
			factory.setProperty(ConnectionConfiguration.imqAddressList,
					"mq://localhost:7677,mq://localhost:7677");
						connection = (QueueConnection) factory.createQueueConnection("admin","admin");
			connection.start();
			Session session = (Session) connection.createQueueSession(
					false, Session.AUTO_ACKNOWLEDGE);
			Queue ioQueue = (Queue) session.createQueue( "TestQueue");
			consumer = session.createConsumer(ioQueue);
			consumer.setMessageListener(this);
			System.out.println("Listening to the TestQueue...");
			// Don’t finish - wait for messages
			Thread.sleep(100000);
		} catch (InterruptedException e){
			System.out.println("Error: " + e.getMessage());
		}
		catch (JMSException e){
			System.out.println("Error: " + e.getMessage());
		}
		finally{
			try{
				connection.close();
			} catch (Exception e) {
				System.out.println("Can’t close JMS connection/session "
						+ e.getMessage());
			}
		}
	}
	public static void main(String[] args){
		new MessageReceiver();
	}
	
	@Override
	public void onMessage(Message msg){
		String msgText;
		try{
			if (msg instanceof TextMessage){
				msgText = ((TextMessage) msg).getText();
				System.out.println("Got from the queue: " + msgText);
			}else{
				System.out.println("Got a non-text message");
			}
		}
		catch (JMSException e){
			System.out.println("Error while consuming a message: " +
					e.getMessage());
		}
	}
	

}