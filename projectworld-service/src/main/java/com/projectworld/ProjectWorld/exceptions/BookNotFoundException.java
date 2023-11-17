package com.projectworld.ProjectWorld.exceptions;

public class BookNotFoundException extends RuntimeException {
	public BookNotFoundException(String message) {
		super(message);
	}
}
