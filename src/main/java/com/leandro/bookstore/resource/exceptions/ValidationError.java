package com.leandro.bookstore.resource.exceptions;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardError {

	private List<FieldMessage> errors = new ArrayList<>();
	
	
	public ValidationError() {
		super();		
	}

	public ValidationError(Long timesTemp, Integer status, String error) {
		super(timesTemp, status, error);		
	}

	public List<FieldMessage> getErrors() {
		return errors;
	}

	public void addErrors(String fieldName, String message) {
		this.errors.add(new FieldMessage(fieldName, message));
	}
	
	
}
