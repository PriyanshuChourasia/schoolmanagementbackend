package com.wishalpha.schoolmanagement.master.controllers;


import com.wishalpha.schoolmanagement.common.responseHandler.ResponseHandler;
import com.wishalpha.schoolmanagement.master.dtos.module.ModuleCreateDTO;
import com.wishalpha.schoolmanagement.master.dtos.module.ModuleDTO;
import com.wishalpha.schoolmanagement.master.service.ApplicationModuleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/v1/modules")
@Tag(name = "Application Module",description = "Application modules are to be registered here")
public class ApplicationModuleController {

    @Autowired
    private  ApplicationModuleService applicationModuleService;


    @GetMapping("/")
    public ResponseEntity<Map<String,Object>> getAll(){
        List<ModuleDTO> moduleDTOS = applicationModuleService.getAll();
        return ResponseHandler.generateResponse(moduleDTOS,HttpStatus.OK);
    }

    @Operation(summary = "Creating application modules for role based architecture")
    @PostMapping("/create-module")
    public ResponseEntity<Map<String,Object>> create(@Valid @RequestBody ModuleCreateDTO moduleCreateDTO){
        ModuleDTO moduleDTO = applicationModuleService.create(moduleCreateDTO);
        return ResponseHandler.generateResponse(moduleDTO,"Module created successfully", HttpStatus.CREATED);
    }
}
