package com.jana.creditreportmodel.exceptions;

import java.time.LocalDate;

public class OrderRecordNotCreatedException extends RuntimeException {

	

	
	private static final long serialVersionUID = -6611183322044468525L;

	public OrderRecordNotCreatedException(Long orderId, String billNumber, LocalDate localDate) {
		super(String.format("order with Number %d and name %s bill date %s not created", 
				orderId,billNumber,String.valueOf(localDate)));
 
	}
}
