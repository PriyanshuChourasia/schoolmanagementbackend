package com.wishalpha.schoolmanagement.master.mapper;

import com.wishalpha.schoolmanagement.master.dtos.moduleFeature.CreateModuleFeatureDTO;
import com.wishalpha.schoolmanagement.master.dtos.moduleFeature.ModuleFeatureDTO;
import com.wishalpha.schoolmanagement.master.entities.ApplicationModuleFeatureEntity;
import com.wishalpha.schoolmanagement.master.entities.ApplicationModuleEntity;

public final class ApplicationModuleFeatureMapper {

    private ApplicationModuleFeatureMapper(){
        throw new UnsupportedOperationException("Application Module Feature Mapper Class");
    }

    public static ApplicationModuleFeatureEntity toEntity(CreateModuleFeatureDTO createModuleFeatureDTO, ApplicationModuleEntity module){
        ApplicationModuleFeatureEntity applicationModuleFeatureEntity = new ApplicationModuleFeatureEntity();
        applicationModuleFeatureEntity.setName(createModuleFeatureDTO.name());
        applicationModuleFeatureEntity.setCode(createModuleFeatureDTO.code());
        applicationModuleFeatureEntity.setStatus(createModuleFeatureDTO.status());
        applicationModuleFeatureEntity.setModule(module);
        applicationModuleFeatureEntity.setDescription(createModuleFeatureDTO.description());
        applicationModuleFeatureEntity.setApiPath(createModuleFeatureDTO.apiPath());
        return applicationModuleFeatureEntity;
    }

    public static ModuleFeatureDTO toDTO(ApplicationModuleFeatureEntity applicationModuleFeatureEntity){
        ModuleFeatureDTO moduleFeatureDTO = new ModuleFeatureDTO();
        moduleFeatureDTO.setName(applicationModuleFeatureEntity.getName());
        moduleFeatureDTO.setDescription(applicationModuleFeatureEntity.getDescription());
        moduleFeatureDTO.setCode(applicationModuleFeatureEntity.getCode());
        moduleFeatureDTO.setStatus(applicationModuleFeatureEntity.getStatus().toString());
        return moduleFeatureDTO;
    }
}


