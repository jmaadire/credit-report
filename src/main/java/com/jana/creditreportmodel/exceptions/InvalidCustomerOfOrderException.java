package com.jana.creditreportmodel.exceptions;

public class InvalidCustomerOfOrderException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2883029509286993418L;
	

	public InvalidCustomerOfOrderException(Long customerNumber, Long orderId) {
		super(String.format("Customer with Number %d is not having order id %d", 
				customerNumber,orderId));
	}

}
