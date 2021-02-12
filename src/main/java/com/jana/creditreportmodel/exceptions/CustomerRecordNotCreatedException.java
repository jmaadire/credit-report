package com.jana.creditreportmodel.exceptions;

public class CustomerRecordNotCreatedException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1165750157729782474L;
	
	

	public CustomerRecordNotCreatedException(Long customerNumber, String customerName) {
		super(String.format("Customer with Number %d and name %S not created", 
				customerNumber,customerName));
 
	}

}
