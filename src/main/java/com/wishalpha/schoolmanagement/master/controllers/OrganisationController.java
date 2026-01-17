package com.wishalpha.schoolmanagement.master.controllers;


import com.wishalpha.schoolmanagement.master.dtos.organisation.OrganisationCreateDTO;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/organisations")
@Tag(name = "Organisation API's")
public class OrganisationController {

//    @PostMapping("/create")
//    public ResponseEntity<Map<String,Object>> createOrganisation(@Valid @RequestBody OrganisationCreateDTO organisationCreateDTO){
//
//    }
}
