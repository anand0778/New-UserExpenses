package com.sintoli.exception;

public class ResourceNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6929820909924640547L;

	public ResourceNotFoundException(String message) {
		super(message);
	}
}
