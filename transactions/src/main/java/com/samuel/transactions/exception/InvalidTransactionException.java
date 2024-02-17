package com.samuel.transactions.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class InvalidTransactionException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1381232313510464654L;

	public InvalidTransactionException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public InvalidTransactionException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public InvalidTransactionException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public InvalidTransactionException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public InvalidTransactionException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	
	

}
