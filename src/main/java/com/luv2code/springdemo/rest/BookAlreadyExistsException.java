package com.luv2code.springdemo.rest;

public class BookAlreadyExistsException extends RuntimeException { 
	
	public BookAlreadyExistsException(String message, Throwable cause) {
		super(message, cause);
	}

	public BookAlreadyExistsException(String message) {
		super(message);
	}

	public BookAlreadyExistsException(Throwable cause) {
		super(cause);
	}


}
