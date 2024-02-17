package com.samuel.transactions.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.samuel.transactions.response.RootResponse;

@ControllerAdvice
public class TransactionServiceExceptionHandler {

	
	private final static Logger LOGGER = LoggerFactory.getLogger(TransactionServiceExceptionHandler.class);
	
	// TransactionNotFoundException
	@ExceptionHandler(value = { TransactionNotFoundException.class })
	ResponseEntity<RootResponse<String>> handleException(TransactionNotFoundException ex) {

		return null;
	}

//	// InvalidTransactionException
//	@ExceptionHandler(value = { TransactionExecutionException.class })
//	ResponseEntity<RootResponse<String>> handleException(RuntimeException ex) {
//
//		return null;
//
//	}

	// TransactionExecutionException
	@ExceptionHandler(value = { TransactionExecutionException.class })
	ResponseEntity<RootResponse<String>> handleException(TransactionExecutionException ex) {

		LOGGER.info("@@@@@@ inside TransactionExecutionException handler");

		return new ResponseEntity<RootResponse<String>>(new RootResponse<String>("error",String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()), HttpStatus.INTERNAL_SERVER_ERROR.toString(),ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
