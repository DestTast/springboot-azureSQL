package com.upc.controller;

import com.upc.exeption.Venta_ProductoNotfoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class Venta_ProductoExceptionController {

    @ExceptionHandler(value = Venta_ProductoNotfoundException.class)
    public ResponseEntity<Object> exception(Venta_ProductoNotfoundException exception)
    {
        return new ResponseEntity<>("Venta_Producto not found", HttpStatus.NOT_FOUND);
    }
}


