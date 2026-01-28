package com.example.quizapp.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleResourceNotFound(
            ResourceNotFoundException ex) {

        ErrorResponse error = new ErrorResponse(
                LocalDateTime.now(),
                ex.getMessage(),
                "Resource not found"
        );

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
	
	 @ExceptionHandler(UserAlreadyExistsException.class)
	    public ResponseEntity<ErrorResponse> handleUserAlreadyExists(
	            UserAlreadyExistsException ex) {

	        ErrorResponse error = new ErrorResponse(
	                LocalDateTime.now(),
	                ex.getMessage(),
	                "User already exists"
	        );

	        return new ResponseEntity<>(error, HttpStatus.CONFLICT);
	    }
	 
	 @ExceptionHandler(InvalidCredentialsException.class)
	    public ResponseEntity<ErrorResponse> handleInvalidCredentials(
	            InvalidCredentialsException ex) {

	        ErrorResponse error = new ErrorResponse(
	                LocalDateTime.now(),
	                ex.getMessage(),
	                "Invalid login"
	        );

	        return new ResponseEntity<>(error, HttpStatus.UNAUTHORIZED);
	    }
	 

	    @ExceptionHandler(Exception.class)
	    public ResponseEntity<ErrorResponse> handleGlobalException(
	            Exception ex) {

	        ErrorResponse error = new ErrorResponse(
	                LocalDateTime.now(),
	                ex.getMessage(),
	                "Internal Server Error"
	        );

	        return new ResponseEntity<>(error,
	                HttpStatus.INTERNAL_SERVER_ERROR);
	    }
}
