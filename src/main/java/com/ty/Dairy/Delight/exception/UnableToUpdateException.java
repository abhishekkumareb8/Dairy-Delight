package com.ty.Dairy.Delight.exception;

public class UnableToUpdateException extends RuntimeException {

	private String message = "Unable to update ";

	public UnableToUpdateException(String message) {

		this.message = message;
	}

	public UnableToUpdateException() {

	}

	@Override
	public String getMessage() {
		return message;
	}
}