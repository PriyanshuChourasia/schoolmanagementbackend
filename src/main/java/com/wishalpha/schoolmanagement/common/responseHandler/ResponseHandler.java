package com.wishalpha.schoolmanagement.common.responseHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResponseHandler {
    public static <T> ResponseEntity<Map<String,Object>> generateResponse(String message, List<T> data, HttpStatus httpStatus, boolean success){
        Map<String,Object> res = new HashMap<String,Object>();
        res.put("data",data);
        res.put("success",success);
        res.put("code",httpStatus);
        res.put("message", message);
        return new ResponseEntity<Map<String,Object>>(res,httpStatus);
    }

    public static <T> ResponseEntity<Map<String,Object>> generateResponse(List<T> data, HttpStatus httpStatus, boolean success){
        Map<String,Object> res = new HashMap<String,Object>();
        res.put("data",data);
        res.put("success",success);
        res.put("code",httpStatus);
        if(success){
            res.put("message", data.size()+" data fetched successfully");
        }else{
            res.put("message","Error Occurred");
        }
        return new ResponseEntity<Map<String,Object>>(res,httpStatus);
    }

    public static <T> ResponseEntity<Map<String,Object>> generateResponse(String message, Object data, HttpStatus httpStatus, boolean success){
        Map<String,Object> res = new HashMap<String,Object>();
        res.put("data",data);
        res.put("message",message);
        res.put("success",success);
        res.put("status",httpStatus);
        return new ResponseEntity<Map<String,Object>>(res,httpStatus);
    }

    public static <T> ResponseEntity<Map<String,Object>> generateResponse(String message){
        Map<String,Object> res = new HashMap<String,Object>();
        res.put("message",message);
        res.put("success",true);
        res.put("status",200);
        return new ResponseEntity<Map<String,Object>>(res,HttpStatus.OK);
    }
}
