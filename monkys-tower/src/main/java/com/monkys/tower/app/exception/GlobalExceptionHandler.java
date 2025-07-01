package com.monkys.tower.app.exception;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice // Este componente se utiliza para manejar excepciones globalmente
public class GlobalExceptionHandler {
	
	ErrorDetails errorDetails;
		
	public GlobalExceptionHandler(ErrorDetails errorDetails) {
		this.errorDetails = errorDetails;
	}

	@ExceptionHandler(IllegalStateException.class)
	ErrorDetails handleIllegalStateException(Exception exception) {
		errorDetails.setTimestamp( LocalDateTime.now() );
		errorDetails.setMessage(exception.getMessage());
		errorDetails.setErrorCode("Resource not found");
		
		return errorDetails;
	}
	
    // Method to handle generic exceptions
    @ExceptionHandler(Exception.class)
    ErrorDetails handleGeneralException(Exception exception) {
        errorDetails.setTimestamp( LocalDateTime.now() );
		errorDetails.setMessage(exception.getMessage());
		errorDetails.setErrorCode("Internal Server Error");
		
		return errorDetails;
    }

}
