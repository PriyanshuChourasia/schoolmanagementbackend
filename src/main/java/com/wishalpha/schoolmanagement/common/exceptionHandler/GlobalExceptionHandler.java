package com.wishalpha.schoolmanagement.common.exceptionHandler;


import com.wishalpha.schoolmanagement.common.exceptionHandler.exceptions.DataNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DataNotFoundException.class)
    public ResponseEntity<Map<String,Object>> handleDataNotFoundException(DataNotFoundException ex){
        Map<String,Object> res = new HashMap<String,Object>();
        res.put("message",ex.getMessage());
        res.put("code", HttpStatus.NOT_FOUND);
        res.put("success",false);
        return new ResponseEntity<Map<String,Object>>(res,HttpStatus.NOT_FOUND);
    }
}
