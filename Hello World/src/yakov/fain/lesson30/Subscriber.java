package yakov.fain.lesson30;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.jms.TopicSession;
import javax.jms.TopicSubscriber;

import com.sun.messaging.ConnectionFactory;
import com.sun.messaging.jms.QueueConnection;
import com.sun.messaging.jms.Session;

public class Subscriber /*implements MessageListener*/{

	/*public static void main(String[] args) {
		ConnectionFactory factory =  new com.sun.messaging.ConnectionFactory();
		QueueConnection connection=null;
		connection = (QueueConnection) factory.createQueueConnection("admin","admin");
		TopicSession subSession =
				((Object) connection).createTopicSession(false, Session.AUTO_ACKNOWLEDGE);
		subSession.createTopic("Price_Drop_Alerts");
		Topic topic;
		TopicSubscriber subscriber = subSession.createSubscriber(topic);
		connection.start();
		subscriber.setMessageListener(this);
		
	}

	@Override
	public void onMessage(Message msg) {
		String msgText;
		try{
			if (msg instanceof TextMessage){
				msgText = ((TextMessage) msg).getText();
				System.out.println("Got " + msgText);
			}else{
				System.out.println("Got a non-text message");
			}
		}
		catch (JMSException e){
			System.out.println("Error: " + e.getMessage());
		}
	}*/
}
