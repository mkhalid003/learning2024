package com.thespringboot.restdemo.exception;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorResponse {

	private int httpCode;
	private HttpStatus httpStatus;
	private String responseCode;
	private String message;
	
	public ErrorResponse() {
		// TODO Auto-generated constructor stub
	}
	
	public ErrorResponse(int httpCode, HttpStatus httpStatus, String responseCode, String message) {
		super();
		this.httpCode = httpCode;
		this.httpStatus = httpStatus;
		this.responseCode = responseCode;
		this.message = message;
	}
}
