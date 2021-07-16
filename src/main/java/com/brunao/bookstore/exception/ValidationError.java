package com.brunao.bookstore.exception;

import java.util.ArrayList;
import java.util.List;

import com.brunao.bookstore.controller.exceptions.FieldMessage;


public class ValidationError extends StandartError{

	private List<FieldMessage> errors = new ArrayList<>();
	
	public ValidationError() {
		super();
	}

	public ValidationError(Long timestamp, Integer status, String error) {
		super(timestamp, status, error);
	}

	public List<FieldMessage> getErrors() {
		return errors;
	}

	public void addError(String fieldName, String message) {
		errors.add(new FieldMessage(fieldName, message));
	}

	
}
