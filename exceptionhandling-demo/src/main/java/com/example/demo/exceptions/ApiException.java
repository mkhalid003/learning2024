package com.example.demo.exceptions;

import org.springframework.http.HttpStatus;

public class ApiException extends Exception {
	private static final long serialVersionUID = -2763311746914759018L;

	private HttpStatus httpStatus;
	private String errorCode;
	private String message;

	public ApiException(HttpStatus httpStatus, String errorCode, String message) {
		super();
		this.httpStatus = httpStatus;
		this.message = message;
		this.errorCode = errorCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

}
