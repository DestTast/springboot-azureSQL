package com.upc.controller;

import com.upc.exeption.VentasNotfoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class VentasExceptionController
{
    @ExceptionHandler(value = VentasNotfoundException.class)
    public ResponseEntity<Object> exception(VentasNotfoundException exception)
    {
        return new ResponseEntity<>("Ventas not found", HttpStatus.NOT_FOUND);
    }
}
