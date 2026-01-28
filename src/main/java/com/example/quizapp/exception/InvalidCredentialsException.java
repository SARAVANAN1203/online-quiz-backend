package com.example.quizapp.exception;

public class InvalidCredentialsException extends RuntimeException {

	public InvalidCredentialsException(String message) {
        super(message);
    }
}
