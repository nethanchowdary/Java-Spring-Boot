package com.adminms.farmer.exceptions;

public class FarmerNotFoundException extends RuntimeException{
    public FarmerNotFoundException(String message) {
        super(message);
    }
}
