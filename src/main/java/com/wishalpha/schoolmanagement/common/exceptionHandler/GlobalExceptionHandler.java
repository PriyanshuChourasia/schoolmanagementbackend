package com.wishalpha.schoolmanagement.common.exceptionHandler;


import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.wishalpha.schoolmanagement.common.exceptionHandler.exceptions.DataNotFoundException;
import com.wishalpha.schoolmanagement.common.exceptionHandler.exceptions.JwtException;
import com.wishalpha.schoolmanagement.common.exceptionHandler.exceptions.JwtMalformedException;
import com.wishalpha.schoolmanagement.common.responseHandler.ResponseHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DataNotFoundException.class)
    public ResponseEntity<Map<String,Object>> handleDataNotFoundException(DataNotFoundException ex){
        Map<String,Object> res = new HashMap<String,Object>();
        res.put("message",ex.getMessage());
        res.put("code", HttpStatus.NOT_FOUND);
        res.put("success",false);
        return new ResponseEntity<Map<String,Object>>(res,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(JwtMalformedException.class)
    public ResponseEntity<Map<String,Object>> handleJwtMalformedException(JwtMalformedException ex){
        return ResponseHandler.generateErrorResponse(ex.getMessage());
    }

    @ExceptionHandler(JwtException.class)
    public ResponseEntity<Map<String,Object>> handleJwtException(JwtException jex){
        return ResponseHandler.generateErrorResponse(jex.getMessage());
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<Map<String,Object>> handleEnumError(HttpMessageNotReadableException ex){
        if(ex.getCause() instanceof InvalidFormatException ife && ife.getTargetType().isEnum()){
            return ResponseHandler.generateErrorResponse("Invalid Enum value",HttpStatus.BAD_REQUEST);
        }
        return ResponseHandler.generateErrorResponse("Malformed Request",HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,Object>> handleMethodNotValidError(MethodArgumentNotValidException ex){
        Map<String,Object> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error ->
            errors.put(error.getField(),error.getDefaultMessage())
        );
        return ResponseHandler.generateErrorResponse(ex.getMessage());
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Map<String,Object>> handleConflict(IllegalArgumentException ex){
        return ResponseHandler.generateResponse(ex.getMessage());
    }

}
