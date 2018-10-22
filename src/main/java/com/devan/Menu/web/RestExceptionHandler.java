package com.devan.Menu.web;

import com.devan.Menu.web.exception.ValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.persistence.EntityNotFoundException;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity entityNotFoundHandler(EntityNotFoundException ex) {

        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity illegalArgumentHandler(IllegalArgumentException ex) {

        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity validationHandler(ValidationException ex) {

        return ResponseEntity.badRequest().body(ex.getResult().getAllErrors());
    }
}
