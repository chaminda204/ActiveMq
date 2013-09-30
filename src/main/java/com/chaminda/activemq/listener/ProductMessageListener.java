/**
 * 
 */
package com.chaminda.activemq.listener;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

import org.springframework.stereotype.Component;

import com.chaminda.activemq.domain.Product;

/**
 * @author chaminda
 *         <p/>
 *         date 08/09/2013
 */
@Component
public class ProductMessageListener implements MessageListener {

	public void onMessage(final Message message) {
		
		if (message instanceof ObjectMessage) {
			
			final ObjectMessage objectMessage = (ObjectMessage) message;
			
			try {
				
				Product product = (Product) objectMessage.getObject();
			
			} catch (JMSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

}
