package com.example.sudarshan_projectspringboot.advice;

import com.example.sudarshan_projectspringboot.exception.ProductNotFoundException;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class ControllerAdvise {

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<String> getProductNotFound(ProductNotFoundException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatusCode.valueOf(400));


    }
}