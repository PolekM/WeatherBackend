package com.weather.exception;

import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler {


    @ExceptionHandler(ApiException.class)
    public ResponseEntity<Error> handleApiException(Exception e) {
        Error error = new Error();

        error.setCode(HttpStatus.BAD_REQUEST.value());
        error.setMessage(e.getMessage());

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({ConstraintViolationException.class, MethodArgumentNotValidException.class})
    public ResponseEntity<Error> handleValidationExceptions(Exception e) {
        Error error = new Error();
        error.setCode(HttpStatus.BAD_REQUEST.value());
        error.setMessage(e.getMessage());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

}
