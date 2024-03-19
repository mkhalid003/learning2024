package com.example.demo.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.demo.model.ErrorResponse;

@ControllerAdvice
public class GlobalExceptionHandler {

	private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	@ExceptionHandler(ProductNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleProductNotFoundException(ProductNotFoundException ex) {
		LOGGER.error("Business Exception: ", ex.getMessage());
		ErrorResponse errorResponse = new ErrorResponse(HttpStatus.NOT_FOUND.value(), ex.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
	}

	@ExceptionHandler(ApiException.class)
	public ResponseEntity<ErrorResponse> handleApiException(ApiException ex) {
		LOGGER.error("Business Exception: ", ex.getMessage());
		ErrorResponse errorResponse = new ErrorResponse(HttpStatus.BAD_REQUEST.value(), ex.getMessage());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
	}

	@ExceptionHandler(InvalidInputException.class)
	public ResponseEntity<Object> handleInvalidInputException(InvalidInputException ex) {
		LOGGER.error("Invalid Input Exception: ", ex.getMessage());
		ErrorResponse errorResponse = new ErrorResponse(HttpStatus.BAD_REQUEST.value(), ex.getMessage());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);

	}

	@ExceptionHandler(BusinessException.class)
	public ResponseEntity<Object> handleBusinessException(BusinessException ex) {
		LOGGER.error("Business Exception: ", ex.getMessage());
		ErrorResponse errorResponse = new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage());
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);

	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse> handleException(Exception ex) {
		LOGGER.error("Exception: ", ex.getMessage());
		ErrorResponse errorResponse = new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage());
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);

	}

}