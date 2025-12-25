package com.wishalpha.schoolmanagement.common.exceptionHandler.exceptions;

public class DataNotFoundException extends RuntimeException{
    public DataNotFoundException(String message){
        super(message);
    }
}
