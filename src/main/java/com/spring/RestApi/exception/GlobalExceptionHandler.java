package com.spring.RestApi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<Object> usernotfound(UserNotFoundException u)
	{
		return new ResponseEntity<>(u.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
