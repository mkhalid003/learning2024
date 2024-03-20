package com.thespringboot.restdemo.exception;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApiException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private HttpStatus httpStatus;
	private String errorCode;
	private String message;
	
	public ApiException(HttpStatus httpStatus, String errorCode, String message) {
		super();
		this.httpStatus = httpStatus;
		this.errorCode = errorCode;
		this.message = message;
	}
}
