/**
 * 
 */
package com.chaminda.activemq.publisher;

import javax.jms.Connection;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;

import com.chaminda.activemq.domain.AbstractEntity;


/**
 * @author chaminda
 *         <p/>
 *         date 08/09/2013
 */

public abstract class AbstractMessagePublisher<T extends AbstractEntity> {
	@Autowired
	private JmsTemplate jmsTemplate;
	
	@Autowired
	ActiveMQConnectionFactory connectionFactory;
	
	@Autowired
	Destination destination;

	public void publishMessage(T domainClass) {
		
        Connection connection =null;
        Session session = null;
		try {
			connection = connectionFactory.createConnection();
			connection.start();

	        // Create a Session
	        session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

	        // Create a MessageProducer from the Session to the Topic or Queue
	        MessageProducer producer = session.createProducer(destination);
	        producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);

	        // Create a messages
	        Message message = getMessage(session, domainClass);

	        // Tell the producer to send the message
	        producer.send(message);
	        System.out.println("Message Published");

	        
	        
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			if(connection != null)
			{
				try {
					// Clean up
			        session.close();
					connection.close();
				} catch (JMSException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
        
		

	}
	
	 protected abstract Message getMessage(Session session, T domainClass);
     

}
