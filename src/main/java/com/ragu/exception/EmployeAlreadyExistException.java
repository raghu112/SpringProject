package com.ragu.exception;



public class EmployeAlreadyExistException extends RuntimeException{
	private String errorMessage;

	public EmployeAlreadyExistException() {
}
	public EmployeAlreadyExistException(String errorMessage) {
		super(errorMessage);
		this.errorMessage = errorMessage;
	}
	
}