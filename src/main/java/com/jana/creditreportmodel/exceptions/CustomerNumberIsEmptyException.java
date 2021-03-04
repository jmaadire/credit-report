package com.jana.creditreportmodel.exceptions;

public class CustomerNumberIsEmptyException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2001078253898926257L;
	


	public CustomerNumberIsEmptyException(String customerName) {
		super(String.format("Customer with name %S having customer name is empty",customerName));	
		
	}



	

}
