package com.wishalpha.schoolmanagement.master.service;


import com.wishalpha.schoolmanagement.master.dtos.moduleFeature.CreateModuleFeatureDTO;
import com.wishalpha.schoolmanagement.master.dtos.moduleFeature.ModuleFeatureDTO;

public interface ApplicationModuleFeatureService {
    ModuleFeatureDTO create(CreateModuleFeatureDTO createModuleFeatureDTO);
}
