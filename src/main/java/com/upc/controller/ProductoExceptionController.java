package com.upc.controller;

import com.upc.exeption.ProductoNotfoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ProductoExceptionController {

    @ExceptionHandler(value = ProductoNotfoundException.class)
    public ResponseEntity<Object> exception(ProductoNotfoundException exception)
    {
        return new ResponseEntity<>("Producto not found", HttpStatus.NOT_FOUND);
    }
}


