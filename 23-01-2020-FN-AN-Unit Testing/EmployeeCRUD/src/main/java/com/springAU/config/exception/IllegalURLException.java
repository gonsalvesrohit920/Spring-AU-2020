package com.springAU.config.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="Illegal URL")  //404 Error
public class IllegalURLException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6759314514353045508L;

}
