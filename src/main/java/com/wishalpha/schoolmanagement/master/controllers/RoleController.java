package com.wishalpha.schoolmanagement.master.controllers;


import com.wishalpha.schoolmanagement.common.responseHandler.ResponseHandler;
import com.wishalpha.schoolmanagement.master.dtos.role.CreateRoleDTO;
import com.wishalpha.schoolmanagement.master.dtos.role.RoleDTO;
import com.wishalpha.schoolmanagement.master.service.UserRoleService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/v1/roles")
@Tag(name = "Role API's")
public class RoleController {

    @Autowired
    private UserRoleService userRoleService;

    @GetMapping("")
    public ResponseEntity<Map<String,Object>> index(){
        List<RoleDTO> roleDTOS = userRoleService.getAll();
        return ResponseHandler.generateResponse(roleDTOS,"Roles Fetched successfully",HttpStatus.OK);
    }


    @PostMapping("/create")
    public ResponseEntity<Map<String,Object>> create(CreateRoleDTO createRoleDTO){
        RoleDTO roleDTO = userRoleService.create(createRoleDTO);
        return ResponseHandler.generateResponse(roleDTO,"Role created successfully", HttpStatus.CREATED);
    }
}
