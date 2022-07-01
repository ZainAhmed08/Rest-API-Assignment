package com.luv2code.springdemo.rest;

public class BookAlreadyExistException extends RuntimeException {

	public BookAlreadyExistException(String message, Throwable cause) {
		super(message, cause);
	}

	public BookAlreadyExistException(String message) {
		super(message);
	}

	public BookAlreadyExistException(Throwable cause) {
		super(cause);
		}
}
