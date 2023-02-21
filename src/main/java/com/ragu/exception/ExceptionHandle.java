package com.ragu.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandle {
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(EmployeAlreadyExistException.class)
	public String error(EmployeAlreadyExistException eh) {
		return eh.getLocalizedMessage();
	}
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(NoSuchEmployeeExistException.class)
	public String error(NoSuchEmployeeExistException eh) {
		return "ERROR : " + eh.getMessage();
}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleValidation(MethodArgumentNotValidException exception) {
		HashMap<String, String> errors = new HashMap<>();
		exception.getBindingResult().getAllErrors().forEach((error) -> {String fieldName = ((FieldError) error).getField();
		String errorMessage = error.getDefaultMessage();
		errors.put(fieldName, errorMessage);});
		return errors;
	}
}
//	@ExceptionHandler(EmployeAlreadyExistException.class)
//	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
//	public HashMap<String, String> handleBuisnessException(EmployeAlreadyExistException exception){
//		HashMap<String, String> errors = new HashMap<>();
//		 errors.put("errorMessage", exception.getMessage());
//		 return errors;
//		 }
//    @ExceptionHandler(NoSuchEmployeeExistException.class)
//	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
//    public HashMap<String, String> handleBuisnessException(NoSuchElementException exception){
//    	HashMap<String, String> errors = new HashMap<>();
//		 errors.put("errorMessage", exception.getMessage());
//		 return errors;
//    }
//}
//		 */
		
	

