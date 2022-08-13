package com.springboot.restservices.exceptions;

public class UserExistsException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserExistsException(String message) {
		super(message);
		
	}

	public String getMessage() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
