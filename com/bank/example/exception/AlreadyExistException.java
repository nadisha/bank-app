package com.bank.example.exception;

public class AlreadyExistException extends Exception {
	public AlreadyExistException() {
		super();
	}
	
	public AlreadyExistException(String message) {
		super(message);
	}
}
