package com.practice.demo.Exceptions;

public class UserNotFoundException extends  RuntimeException{
    public UserNotFoundException(String msg){
        super(msg);
    }
}
