package com.luv2code.springdemo.rest;

public class AuthorNotFoundException extends RuntimeException {

	public AuthorNotFoundException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public AuthorNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public AuthorNotFoundException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
