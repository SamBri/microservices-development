package com.samuel.transactions.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
public class TransactionExecutionException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4264628394679221883L;

	public TransactionExecutionException() {
		super();
	}

	public TransactionExecutionException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public TransactionExecutionException(String message, Throwable cause) {
		super(message, cause);
	}

	public TransactionExecutionException(String message) {
		super(message);
	}

	public TransactionExecutionException(Throwable cause) {
		super(cause);
	}
	
	

}
