package com.wishalpha.schoolmanagement.employee.controller;


import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/employees")
@Tag(name="Employee", description = "Employee API's")
public class EmployeeController {

//    @GetMapping("")
//    public ResponseEntity<Map<String,Object>> index(){
//
//    }
}
