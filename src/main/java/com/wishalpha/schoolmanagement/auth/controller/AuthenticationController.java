package com.wishalpha.schoolmanagement.auth.controller;


import com.wishalpha.schoolmanagement.auth.dto.LoginDTO;
import com.wishalpha.schoolmanagement.auth.utils.JwtUtils;
import com.wishalpha.schoolmanagement.common.responseHandler.ResponseHandler;
import com.wishalpha.schoolmanagement.master.dto.CreateUserDTO;
import com.wishalpha.schoolmanagement.master.dto.UserDTO;
import com.wishalpha.schoolmanagement.master.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping("auth")
@Tag(name = "Auth")
public class AuthenticationController {

    private final static Logger logger = LoggerFactory.getLogger(AuthenticationController.class);
    @Autowired
    private UserService userService;

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Operation(summary = "Register user")
    @PostMapping("/register")
    public ResponseEntity<Map<String,Object>> register(@Valid @RequestBody CreateUserDTO createUserDTO){
        UserDTO userDTO = userService.create(createUserDTO);
        return ResponseHandler.generateResponse("User created successfully",userDTO, HttpStatus.CREATED);
    }

    @PostMapping("/sign-in")
    public ResponseEntity<Map<String,Object>> login(@Valid @RequestBody LoginDTO loginDTO){
        Authentication authentication;
        try{
            authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDTO.getEmail(),loginDTO.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(authentication);
            logger.info("Principal: {}",authentication.getPrincipal());
            UserDetails userDetails = (UserDetails)  authentication.getPrincipal();
            String accessToken = jwtUtils.generateAccessTokenFromUsername(userDetails);
            String refreshToken = jwtUtils.generateRefreshTokenFromUsername(userDetails);
            Map<String,Object> tokens = new HashMap<>();
            tokens.put("accessToken",accessToken);
            tokens.put("refreshToken",refreshToken);
            return ResponseHandler.generateResponse(tokens,HttpStatus.OK);
        }catch (AuthenticationException e){
            logger.info("Auth Exception: {}",e.getMessage());
            return ResponseHandler.generateErrorResponse("Bad Credentials");
        }
    }


    @GetMapping("/profile")
    public ResponseEntity<Map<String,Object>> profile(HttpServletRequest request){
        String token = jwtUtils.getJwtFromHeader(request);
        String username = jwtUtils.getUserNameFromToken(token);
        UserDTO userDTO = userService.getByEmail(username);
        String message = "User Profile fetched successfully";
        return ResponseHandler.generateResponse(message,userDTO,HttpStatus.OK);
    }
}
