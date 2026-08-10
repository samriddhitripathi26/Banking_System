package com.alexa.bank.apps.exception;

public class LoanNotFoundException extends RuntimeException {
	
	public LoanNotFoundException(String message){
		super(message);
	}

}
