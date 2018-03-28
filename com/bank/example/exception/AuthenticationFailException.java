package com.bank.example.exception;

public class AuthenticationFailException extends Exception {
	public AuthenticationFailException() {
		super();
	}
	
	public AuthenticationFailException(String message) {
		super(message);
	}
}
