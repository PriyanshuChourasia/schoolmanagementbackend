package com.wishalpha.schoolmanagement.common.responseHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResponseHandler {
    public static <T> ResponseEntity<Map<String,Object>> generateResponse(List<T> data,String message, HttpStatus httpStatus){
        Map<String,Object> res = new HashMap<String,Object>();
        res.put("data",data);
        res.put("success",true);
        res.put("code",httpStatus.value());
        res.put("message", message);
        return new ResponseEntity<Map<String,Object>>(res,httpStatus);
    }


    public static <T> ResponseEntity<Map<String,Object>> generateResponse(List<T> data, HttpStatus httpStatus){
        Map<String,Object> res = new HashMap<String,Object>();
        res.put("data",data);
        res.put("success",true);
        res.put("code",httpStatus.value());
        res.put("message", data.size()+" data fetched successfully");
        return new ResponseEntity<Map<String,Object>>(res,httpStatus);
    }

    public static <T> ResponseEntity<Map<String,Object>> generateResponse(String key, String value, HttpStatus httpStatus){
        Map<String,Object> res = new HashMap<String,Object>();
        Map<String,Object> keyVal = new HashMap<>();
        keyVal.put("key",key);
        keyVal.put("value",value);
        res.put("data",keyVal);
        res.put("success",true);
        res.put("code",httpStatus.value());
        res.put("message", "Data fetched successfully");
        return new ResponseEntity<Map<String,Object>>(res,httpStatus);
    }



    public static <T> ResponseEntity<Map<String,Object>> generateResponse(Map<String,Object> data, HttpStatus httpStatus){
        Map<String,Object> res = new HashMap<String,Object>();
        res.put("data",data);
        res.put("success",true);
        res.put("code",httpStatus.value());
        res.put("message", " data fetched successfully");
        return new ResponseEntity<Map<String,Object>>(res,httpStatus);
    }

    public static <T> ResponseEntity<Map<String,Object>> generateResponse(Object data, String message, HttpStatus httpStatus){
        Map<String,Object> res = new HashMap<String,Object>();
        res.put("data",data);
        res.put("message",message);
        res.put("success",true);
        res.put("status",httpStatus.value());
        return new ResponseEntity<Map<String,Object>>(res,httpStatus);
    }

    public static <T> ResponseEntity<Map<String,Object>> generateResponse(String message){
        Map<String,Object> res = new HashMap<String,Object>();
        res.put("message",message);
        res.put("success",true);
        res.put("status",200);
        return new ResponseEntity<Map<String,Object>>(res,HttpStatus.OK);
    }


    public static <T> ResponseEntity<Map<String,Object>> generateErrorResponse(String message, HttpStatus httpStatus){
        Map<String,Object> response = new HashMap<String,Object>();
        Map<String,Object> error = new HashMap<String,Object>();
        Map<String,Object> errorMessage = new HashMap<String,Object>();

        errorMessage.put("message",message);
        errorMessage.put("code",httpStatus.value());
        error.put("error",errorMessage);
        response.put("data",error);
        response.put("success",false);
        return new ResponseEntity<Map<String,Object>>(response,httpStatus);
    }

    public static <T> ResponseEntity<Map<String,Object>> generateErrorResponse(String message){
        Map<String,Object> response = new HashMap<String,Object>();
        Map<String,Object> error = new HashMap<String,Object>();
        Map<String,Object> errorMessage = new HashMap<String,Object>();

        errorMessage.put("message",message);
        errorMessage.put("code",HttpStatus.BAD_REQUEST.value());
        error.put("error",errorMessage);
        response.put("data",error);
        response.put("success",false);
        return new ResponseEntity<Map<String,Object>>(response,HttpStatus.BAD_REQUEST);
    }
    public static <T> ResponseEntity<Map<String,Object>> generateErrorResponse(Map<String,Object> message){
        Map<String,Object> response = new HashMap<String,Object>();
        Map<String,Object> error = new HashMap<String,Object>();
        Map<String,Object> errorMessage = new HashMap<String,Object>();

        errorMessage.put("message",message);
        error.put("error",errorMessage);
        response.put("data",error);
        response.put("code",HttpStatus.BAD_REQUEST.value());
        response.put("success",false);
        return new ResponseEntity<Map<String,Object>>(response,HttpStatus.BAD_REQUEST);
    }
}
