package com.upc.controller;

import com.upc.exeption.GerenteNotfoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GerenteExceptionController {

    @ExceptionHandler(value = GerenteNotfoundException.class)
    public ResponseEntity<Object> exception(GerenteNotfoundException exception)
    {
        return new ResponseEntity<>("Gerente not found", HttpStatus.NOT_FOUND);
    }
}


