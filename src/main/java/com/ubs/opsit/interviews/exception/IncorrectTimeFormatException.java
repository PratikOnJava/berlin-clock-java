package com.ubs.opsit.interviews.exception;

public class IncorrectTimeFormatException extends RuntimeException {
	private String message;

	public IncorrectTimeFormatException(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
