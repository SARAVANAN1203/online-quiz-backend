package com.example.quizapp.exception;

public class UserAlreadyExistsException extends RuntimeException {

	public UserAlreadyExistsException(String message) {
        super(message);
    }
}
