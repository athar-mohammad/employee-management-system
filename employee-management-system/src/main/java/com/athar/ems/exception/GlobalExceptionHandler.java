package com.athar.ems.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceAlreadyExistsException.class)
    public ResponseEntity<ErrorDetails> handleResourceAlreadyExistsException(ResourceAlreadyExistsException exception){
        ErrorDetails error = new ErrorDetails(
                LocalDateTime.now(),
                exception.getMessage(),
                "Resource already exists"
        );

        return new ResponseEntity<>(error, HttpStatus.CONFLICT);
    }
}
