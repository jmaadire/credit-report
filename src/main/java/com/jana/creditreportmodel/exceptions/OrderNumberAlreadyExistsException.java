package com.jana.creditreportmodel.exceptions;

import java.time.LocalDate;

public class OrderNumberAlreadyExistsException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3736629460450894811L;
	
	public OrderNumberAlreadyExistsException(Long orderId, String billNumber, LocalDate localDate) {
		super(String.format("order with Number %d and name %s bill date %s is already exists", 
				orderId,billNumber,String.valueOf(localDate)));
 
	}

}
