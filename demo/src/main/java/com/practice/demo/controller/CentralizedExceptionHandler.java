package com.practice.demo.controller;

import com.practice.demo.Exceptions.UserNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CentralizedExceptionHandler
{

    @ExceptionHandler(UserNotFoundException.class)
    public String handleProductNotNoundEcxeption(UserNotFoundException e){
        return e.getMessage();
    }
}
