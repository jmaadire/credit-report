package com.jana.creditreportmodel.exceptions;

public class CustomerNumberAlreadyExistsException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4303867785885981797L;
	

	public CustomerNumberAlreadyExistsException(Long customerNumber, String customerName) {
		super(String.format("Customer with Number %d and name %S  already exists", 
				customerNumber,customerName));
 
	}


}
