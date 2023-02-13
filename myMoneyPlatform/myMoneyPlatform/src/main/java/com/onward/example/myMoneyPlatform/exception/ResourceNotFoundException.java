/**
 * ResourceNotFoundException.java
 * 
 * This class represents a custom exception to be thrown when a resource is not found.
 * 
 * @author [Your Name]
 * 
 */

package com.onward.example.myMoneyPlatform.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Annotation @ResponseStatus sets the HTTP status code for the response. In
 * this case, the HTTP status code is set to 404 (NOT_FOUND).
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
	private String message;
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor to create a ResourceNotFoundException instance
	 * 
	 * @param message the error message for this exception
	 */
	public ResourceNotFoundException(String message) {
		super(message);
		this.message = message;
	}
}
