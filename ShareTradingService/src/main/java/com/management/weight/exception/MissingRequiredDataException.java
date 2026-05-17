package com.management.weight.exception;

public class MissingRequiredDataException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public MissingRequiredDataException(String message) {
		super(message);
	}
}
