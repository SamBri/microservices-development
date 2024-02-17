package com.samuel.transactions.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class TransactionNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7159178050640597753L;

	public TransactionNotFoundException() {
		super();
	}

	public TransactionNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public TransactionNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public TransactionNotFoundException(String message) {
		super(message);
	}

	public TransactionNotFoundException(Throwable cause) {
		super(cause);
	}
	
	
	

}
