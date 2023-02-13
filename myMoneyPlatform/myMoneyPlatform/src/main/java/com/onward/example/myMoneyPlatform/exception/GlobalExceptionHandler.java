package com.onward.example.myMoneyPlatform.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(ResourceNotFoundException.class)
	/*
	 * 
	 * This method is annotated
	 * with @ExceptionHandler(ResourceNotFoundException.class) and is used to handle
	 * the ResourceNotFoundException.
	 * 
	 * @param ex This is the exception object of type ResourceNotFoundException
	 * 
	 * @param request This is the WebRequest object
	 * 
	 * @return ResponseEntity This returns a ResponseEntity with the error details
	 * and a HTTP status code of NOT_FOUND
	 */
	public ResponseEntity<?> resourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
		ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}

	/**
	 * 
	 * This method is annotated with @ExceptionHandler(Exception.class) and is used
	 * to handle any other exception that may occur in the application.
	 * 
	 * @param ex      This is the exception object of type Exception
	 * @param request This is the WebRequest object
	 * @return ResponseEntity This returns a ResponseEntity with the error details
	 *         and a HTTP status code of INTERNAL_SERVER_ERROR
	 */

	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> globleExcpetionHandler(Exception ex, WebRequest request) {
		ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}