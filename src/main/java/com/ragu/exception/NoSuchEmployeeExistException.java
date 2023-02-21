package com.ragu.exception;

public class NoSuchEmployeeExistException extends RuntimeException {
	private String errorMessage;

	public NoSuchEmployeeExistException() {
}

	public NoSuchEmployeeExistException(String errorMessage) {
		super(errorMessage);
		this.errorMessage = errorMessage;
	}


	
}
