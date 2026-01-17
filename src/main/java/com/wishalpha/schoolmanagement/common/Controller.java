package com.wishalpha.schoolmanagement.common;


import com.wishalpha.schoolmanagement.common.responseHandler.ResponseHandler;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/v1/greeting")
@Tag(name = "Index Controller", description = "Base level controller")
public class Controller {

    @GetMapping("")
    public ResponseEntity<Map<String,Object>> index(){
        return ResponseHandler.generateResponse("Welcome to School Management System");
    }
}
