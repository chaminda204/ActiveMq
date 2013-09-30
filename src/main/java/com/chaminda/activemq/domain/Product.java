package com.chaminda.activemq.domain;

public class Product extends AbstractEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long productID;
	
	private String ProductName;
	
	private boolean isOrderProcessed;
	
	private String state;

	/**
	 * @return the productID
	 */
	public Long getProductID() {
		return productID;
	}

	/**
	 * @param productID the productID to set
	 */
	public void setProductID(Long productID) {
		this.productID = productID;
	}

	/**
	 * @return the productName
	 */
	public String getProductName() {
		return ProductName;
	}

	/**
	 * @param productName the productName to set
	 */
	public void setProductName(String productName) {
		ProductName = productName;
	}

	/**
	 * @return the isOrderProcessed
	 */
	public boolean isOrderProcessed() {
		return isOrderProcessed;
	}

	/**
	 * @param isOrderProcessed the isOrderProcessed to set
	 */
	public void setOrderProcessed(boolean isOrderProcessed) {
		this.isOrderProcessed = isOrderProcessed;
	}

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}
	
}

