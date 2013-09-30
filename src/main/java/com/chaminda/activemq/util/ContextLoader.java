/**
 * 
 */
package com.chaminda.activemq.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.chaminda.activemq.domain.ObjectFactory;
import com.chaminda.activemq.domain.Product;
import com.chaminda.activemq.publisher.ProductMessagePublisher;

/**
 * @author chamindaa
 * 
 *         <p/>
 *         date date 29/08/2013
 */
public class ContextLoader {

	private static ApplicationContext appContext;

	private ContextLoader() {

	}

	private static ApplicationContext getContextInstance() {
		if (appContext == null) {
			appContext = new ClassPathXmlApplicationContext(new String[] { "springbeans/activeMqContext.xml" });
		}

		return appContext;
	}

	private static Object getBean(final String beanName) {
		return getContextInstance().getBean(beanName);
	}
	
	public static void main(String[] args)
	{
		ProductMessagePublisher messagePublisher = (ProductMessagePublisher) ContextLoader.getBean("productMessagePublisher");
		Product wa = ObjectFactory.createProduct(123L, "Milk", false, "WA");
		messagePublisher.publishMessage(wa);
		
		Product nsw = ObjectFactory.createProduct(124L, "Bread", false, "NSW");
		messagePublisher.publishMessage(nsw);
		
		Product vic = ObjectFactory.createProduct(125L, "Butter", false, "Vic");
		messagePublisher.publishMessage(vic);
	}

}
