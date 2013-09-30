/**
 * 
 */
package com.chaminda.activemq.publisher;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.Session;

import org.springframework.stereotype.Component;

import com.chaminda.activemq.domain.Product;


/**
 * @author chaminda
 *         <p/>
 *         date 08/09/2013
 */
@Component("productMessagePublisher") 
public class ProductMessagePublisher extends AbstractMessagePublisher<Product> {


	@Override
	protected Message getMessage(Session session, Product product) {
		ObjectMessage message = null;
		
		try {
			message = session.createObjectMessage();
			message.setObject(product);
			
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return message;
	}

}
