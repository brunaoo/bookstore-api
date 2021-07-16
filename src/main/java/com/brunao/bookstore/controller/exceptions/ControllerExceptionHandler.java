package com.brunao.bookstore.controller.exceptions;

import javax.servlet.ServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.brunao.bookstore.exception.ObjectAssociatedException;
import com.brunao.bookstore.exception.ObjectNotFoundException;
import com.brunao.bookstore.exception.StandartError;
import com.brunao.bookstore.exception.ValidationError;

@ControllerAdvice
public class ControllerExceptionHandler {

	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandartError> objectNotFoundException(ObjectNotFoundException e, ServletRequest request){
		StandartError error = new StandartError(System.currentTimeMillis(), HttpStatus.NOT_FOUND.value(), e.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}
	

	@ExceptionHandler(ObjectAssociatedException.class)
	public ResponseEntity<StandartError> objectAssociatedException(ObjectAssociatedException e, ServletRequest request){
		StandartError error = new StandartError(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(), e.getMessage());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<StandartError> validationException(MethodArgumentNotValidException e, ServletRequest request){
		ValidationError error = new ValidationError(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(), "Erro na validação dos campos");
		for(FieldError fe : e.getBindingResult().getFieldErrors() ) {
			error.addError(fe.getField(), fe.getDefaultMessage());
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}
	
}
