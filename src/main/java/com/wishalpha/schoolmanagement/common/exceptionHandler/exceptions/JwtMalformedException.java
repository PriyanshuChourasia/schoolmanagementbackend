package com.wishalpha.schoolmanagement.common.exceptionHandler.exceptions;

import io.jsonwebtoken.MalformedJwtException;

public class JwtMalformedException extends MalformedJwtException {

    public JwtMalformedException(String message) {
        super(message);
    }

    public JwtMalformedException(String message, Throwable cause) {
        super(message, cause);
    }
}
