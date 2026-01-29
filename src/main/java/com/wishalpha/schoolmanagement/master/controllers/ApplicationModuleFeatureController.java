package com.wishalpha.schoolmanagement.master.controllers;


import com.wishalpha.schoolmanagement.common.responseHandler.ResponseHandler;
import com.wishalpha.schoolmanagement.master.dtos.moduleFeature.CreateModuleFeatureDTO;
import com.wishalpha.schoolmanagement.master.dtos.moduleFeature.ModuleFeatureDTO;
import com.wishalpha.schoolmanagement.master.service.ApplicationModuleFeatureService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/v1/features")
@Tag(name = "Application Feature")
@RequiredArgsConstructor
public class ApplicationModuleFeatureController {

    private final ApplicationModuleFeatureService applicationModuleFeatureService;

    @PostMapping("/create")
    public ResponseEntity<Map<String,Object>> create(@Valid @RequestBody CreateModuleFeatureDTO createModuleFeatureDTO){
        ModuleFeatureDTO moduleFeatureDTO = applicationModuleFeatureService.create(createModuleFeatureDTO);
        return ResponseHandler.generateResponse(moduleFeatureDTO,"Modules feature created successfully", HttpStatus.CREATED);
    }
}
