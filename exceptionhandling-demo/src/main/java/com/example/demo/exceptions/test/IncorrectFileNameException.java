package com.example.demo.exceptions.test;

public class IncorrectFileNameException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public IncorrectFileNameException(String errorMessage) {
		super(errorMessage);
	}
	
	// we can use custom exceptions without losing the root cause from which they occurred.
	public IncorrectFileNameException(String errorMessage, Throwable err) {
	    super(errorMessage, err);
	}
}