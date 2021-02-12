package com.jana.creditreportmodel.exceptions;

public class NoDataFoundException extends RuntimeException {

    /**
	 * 
	 */
	private static final long serialVersionUID = 8412902534000628813L;

	public NoDataFoundException() {

        super("No data found");
    }
}

