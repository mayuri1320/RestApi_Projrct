package com.spring.RestApi.exception;

public class UserNotFoundException extends Exception {

	public UserNotFoundException(String msg)
	{
		super(msg);
	}
}
