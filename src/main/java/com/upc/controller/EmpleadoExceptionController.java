package com.upc.controller;

import com.upc.exeption.EmpleadoNotfoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class EmpleadoExceptionController {

    @ExceptionHandler(value = EmpleadoNotfoundException.class)
    public ResponseEntity<Object> exception(EmpleadoNotfoundException exception)
    {
        return new ResponseEntity<>("Empleado not found", HttpStatus.NOT_FOUND);
    }
}


