package com.samuel.users.exception;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

import com.samuel.users.response.RootResponse;

import jakarta.servlet.http.HttpServletRequest;


@ControllerAdvice
public class UserServiceExceptionHandler  {
	
	
	// UserNotFoundException  
	@ExceptionHandler(value = { UserNotFoundException.class })
	ResponseEntity<RootResponse<String>> handleException(UserNotFoundException ex) {

		return null;
	}
	
	// InvalidUserException
	@ExceptionHandler(value = { HttpMessageNotReadableException.class, MethodArgumentNotValidException.class})
	ResponseEntity<RootResponse<Object>> InvalidUserExceptionHandler (RuntimeException ex){
		
		System.out.println("inside ");
		
		RootResponse<Object> exceptionResponse = new RootResponse<Object>();
		
		
		exceptionResponse.setStatus("error");
		exceptionResponse.setResponse(HttpStatus.BAD_REQUEST.name());
		exceptionResponse.setCode("400");
		exceptionResponse.setMessage(ex.getMessage());
		
		return new ResponseEntity<RootResponse<Object>>(exceptionResponse, HttpStatus.BAD_REQUEST);
		
	}
	
	

	// UserExecutionException
	@ExceptionHandler(value = {RuntimeException.class})
	ResponseEntity<RootResponse<Object>> handleException (UserExecutionException ex){
				
		RootResponse<Object> exceptionResponse = new RootResponse<Object>();
		
		
		exceptionResponse.setStatus("error");
		exceptionResponse.setResponse(ex.getMessage());
		exceptionResponse.setCode("500");
		exceptionResponse.setMessage("UserExecution Error");
		
		return new ResponseEntity<RootResponse<Object>>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
		

	
}
