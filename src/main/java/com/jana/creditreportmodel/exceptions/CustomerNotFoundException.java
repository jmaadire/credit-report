package com.jana.creditreportmodel.exceptions;

public class CustomerNotFoundException extends RuntimeException {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1485506742723383536L;

	public CustomerNotFoundException(Long id) {
        super(String.format("Customer with Id %d not found", id));
    }
	
	
}