package com.upc.controller;

import com.upc.exeption.Tipo_ProductoNotfoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class Tipo_ProductoExceptionController {

    @ExceptionHandler(value = Tipo_ProductoNotfoundException.class)
    public ResponseEntity<Object> exception(Tipo_ProductoNotfoundException exception)
    {
        return new ResponseEntity<>("Tipo_Producto not found", HttpStatus.NOT_FOUND);
    }
}


