package com.wishalpha.schoolmanagement.common.exceptionHandler;


import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.wishalpha.schoolmanagement.common.exceptionHandler.exceptions.DataAlreadyExistsException;
import com.wishalpha.schoolmanagement.common.exceptionHandler.exceptions.DataNotFoundException;
import com.wishalpha.schoolmanagement.common.exceptionHandler.exceptions.JwtException;
import com.wishalpha.schoolmanagement.common.exceptionHandler.exceptions.JwtMalformedException;
import com.wishalpha.schoolmanagement.common.responseHandler.ResponseHandler;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    /***
     * Generic Exception
     * This will handle every generic exception which needs to be handled
     * */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String,Object>> exception(Exception ex){
        ex.printStackTrace();
        return ResponseHandler.generateErrorResponse(ex.getMessage(),HttpStatus.BAD_REQUEST);
    }

//    Data not found
    @ExceptionHandler(DataNotFoundException.class)
    public ResponseEntity<Map<String,Object>> handleDataNotFoundException(DataNotFoundException ex){
        return ResponseHandler.generateErrorResponse(ex.getMessage(),HttpStatus.BAD_REQUEST);
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
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<Map<String,Object>> handleConflict(IllegalArgumentException ex){
        return ResponseHandler.generateErrorResponse(ex.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(DataAlreadyExistsException.class)
    public ResponseEntity<Map<String,Object>> handleExistsError(DataAlreadyExistsException ex){
        return ResponseHandler.generateErrorResponse(ex.getMessage(),HttpStatus.CONFLICT);
    }


    /**
     * DataIntegrityViolationException
     * **/
    @ExceptionHandler(DataIntegrityViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Map<String,Object>> dataIntegrityViolationException(DataIntegrityViolationException ex){
        return  ResponseHandler.generateErrorResponse(ex.getMessage(),HttpStatus.BAD_REQUEST);
    }


//    UnSupportedOperationException
    @ExceptionHandler(UnsupportedOperationException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ResponseEntity<Map<String,Object>> unSupportedOperationException(UnsupportedOperationException ex){
        return ResponseHandler.generateErrorResponse(ex.getMessage(),HttpStatus.CONFLICT);
    }


}
