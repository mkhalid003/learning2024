package com.example.demo.exceptions;

public class ProductNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ProductNotFoundException(Long productId) {
		super( "Product not found with ID: " + productId);
	}
}