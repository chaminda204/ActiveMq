/**
 * 
 */
package com.chaminda.activemq.domain;
/**
 * @author chaminda
 *         <p/>
 *         date 18/09/2013
 */
public class ObjectFactory {
	
	private ObjectFactory() {

	}

	public static Product createProduct(Long id, String productName, boolean isProcessed, String state) {
		Product product = new Product();
		product.setProductID(id);
		product.setProductName(productName);
		product.setOrderProcessed(isProcessed);
		product.setState(state);

		return product;
	}
}
