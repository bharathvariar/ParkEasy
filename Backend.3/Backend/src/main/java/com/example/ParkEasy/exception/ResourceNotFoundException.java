package com.example.ParkEasy.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String reesourceName;
	private String fieldName;
	private Object fieldValue;

	public ResourceNotFoundException(String reesourceName, String fieldName, Object fieldValue) {
		super();
		this.reesourceName = reesourceName;
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
	}

	public String getReesourceName() {
		return reesourceName;
	}

	public String getFieldName() {
		return fieldName;
	}

	public Object getFieldValue() {
		return fieldValue;
	}

}
