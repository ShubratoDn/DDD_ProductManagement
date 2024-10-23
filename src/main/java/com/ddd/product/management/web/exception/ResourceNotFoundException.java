package com.ddd.product.management.web.exception;

public class ResourceNotFoundException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ResourceNotFoundException(String message) {
        super(message);
    }
	
	public ResourceNotFoundException() {
        super("A resource not found");
    }
}
