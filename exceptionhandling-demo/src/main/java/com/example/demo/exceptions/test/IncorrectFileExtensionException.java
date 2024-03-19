package com.example.demo.exceptions.test;

public class IncorrectFileExtensionException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public IncorrectFileExtensionException(String errorMessage) {
		super(errorMessage);
	}
	
	public IncorrectFileExtensionException(String errorMessage, Throwable err) {
		super(errorMessage, err);
	}
}