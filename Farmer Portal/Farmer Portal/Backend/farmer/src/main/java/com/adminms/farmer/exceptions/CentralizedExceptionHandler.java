package com.adminms.farmer.exceptions;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CentralizedExceptionHandler {

    @ExceptionHandler(FarmerNotFoundException.class)
    public String handleFarmerNotFoundException(FarmerNotFoundException e){
        return e.getMessage();
    }

}
