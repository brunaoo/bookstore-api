package com.brunao.bookstore.exception;

public class ObjectAssociatedException  extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ObjectAssociatedException(String message, Throwable cause) {
		super(message, cause);
	}

	public ObjectAssociatedException(String message) {
		super(message);
	}

}
