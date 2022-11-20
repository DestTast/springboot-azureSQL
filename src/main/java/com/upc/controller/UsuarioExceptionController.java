package com.upc.controller;

import com.upc.exeption.UsuarioNotfoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UsuarioExceptionController {

    @ExceptionHandler(value = UsuarioNotfoundException.class)
    public ResponseEntity<Object> exception(UsuarioNotfoundException exception)
    {
        return new ResponseEntity<>("Usuario not found", HttpStatus.NOT_FOUND);
    }
}


