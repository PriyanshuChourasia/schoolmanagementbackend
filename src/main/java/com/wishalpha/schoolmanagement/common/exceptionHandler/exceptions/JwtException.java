package com.wishalpha.schoolmanagement.common.exceptionHandler.exceptions;

public class JwtException extends RuntimeException{
    public JwtException(String message){
        super(message);
    }
}
