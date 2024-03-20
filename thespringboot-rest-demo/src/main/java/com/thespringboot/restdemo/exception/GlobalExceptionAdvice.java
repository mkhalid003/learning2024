package com.thespringboot.restdemo.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionAdvice {

	private static final Logger LOG = LoggerFactory.getLogger(GlobalExceptionAdvice.class);
	
	@ExceptionHandler(ApiException.class)
	public ResponseEntity<ErrorResponse> handleApiException(ApiException ex){
		
		ErrorResponse errResponse = new ErrorResponse();
		errResponse.setHttpCode(ex.getHttpStatus().value());
		errResponse.setHttpStatus(ex.getHttpStatus());
		errResponse.setResponseCode(ex.getErrorCode());
		errResponse.setMessage(ex.getMessage());
		LOG.error("Exception Details: ", ex);
		return new ResponseEntity<ErrorResponse>(errResponse, ex.getHttpStatus());
		
	}
}
