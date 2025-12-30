package com.wishalpha.schoolmanagement.auth.controller;


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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping("auth")
@Tag(name = "Auth")
public class AuthenticationController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<Map<String,Object>> register(@Valid @RequestBody CreateUserDTO createUserDTO){
        UserDTO userDTO = userService.create(createUserDTO);
        return ResponseHandler.generateResponse("User created successfully",userDTO, HttpStatus.CREATED);
    }

    @PostMapping("/sign-in")
    public ResponseEntity<Map<String,Object>> login(@Valid)
}
