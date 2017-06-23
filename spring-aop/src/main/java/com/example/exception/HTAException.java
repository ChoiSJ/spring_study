package com.example.exception;

public class HTAException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public HTAException(String message) {
		super(message);
	}
	
	public HTAException(String message, Throwable cause) {
		super(message, cause);
	}
}
