package com.jana.creditreportmodel.exceptions;

public class OrderNotFoundException extends RuntimeException {

    /**
	 * 
	 */
	private static final long serialVersionUID = -4467359365138169957L;

	public OrderNotFoundException(Long id) {

        super(String.format("Order with Id %d not found", id));
    }
}