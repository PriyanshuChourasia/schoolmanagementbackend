package com.wishalpha.schoolmanagement.master.controller;


import com.wishalpha.schoolmanagement.common.responseHandler.ResponseHandler;
import com.wishalpha.schoolmanagement.master.dto.CreateUserDTO;
import com.wishalpha.schoolmanagement.master.dto.UserDTO;
import com.wishalpha.schoolmanagement.master.service.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
@Tag(name = "User API's")
public class UserController {

    @Autowired
    private  UserService userService;

    @GetMapping("")
    public ResponseEntity<Map<String,Object>> index(){
        List<UserDTO> userDTOS = userService.getAll();
        return ResponseHandler.generateResponse(userDTOS,HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Map<String,Object>> create(@Valid @RequestBody CreateUserDTO createUserDTO){
        UserDTO userDTO = userService.create(createUserDTO);
        String message = "User created successfully";
        return ResponseHandler.generateResponse(message,userDTO, HttpStatus.CREATED);
    }
}
