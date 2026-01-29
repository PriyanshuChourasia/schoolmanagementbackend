package com.wishalpha.schoolmanagement.master.mapper;

import com.wishalpha.schoolmanagement.master.dtos.module.ModuleCreateDTO;
import com.wishalpha.schoolmanagement.master.dtos.module.ModuleDTO;
import com.wishalpha.schoolmanagement.master.entities.ApplicationModuleEntity;

public class ApplicationModuleMapper {
    public static ApplicationModuleEntity toEntity(ModuleCreateDTO moduleCreateDTO){
        ApplicationModuleEntity applicationModuleEntity = new ApplicationModuleEntity();
        applicationModuleEntity.setName(moduleCreateDTO.name());
        applicationModuleEntity.setCode(moduleCreateDTO.code());
        applicationModuleEntity.setDescription(moduleCreateDTO.description());
        applicationModuleEntity.setStatus(moduleCreateDTO.status());
        applicationModuleEntity.setFrontendRoutePath(moduleCreateDTO.frontEndPath());
        return applicationModuleEntity;
    }

    public static ModuleDTO toDTO(ApplicationModuleEntity applicationModuleEntity){
        ModuleDTO moduleDTO = new ModuleDTO();
        moduleDTO.setName(applicationModuleEntity.getName());
        moduleDTO.setCode(applicationModuleEntity.getCode());
        moduleDTO.setDescription(applicationModuleEntity.getDescription());
        moduleDTO.setStatus(applicationModuleEntity.getStatus());
        moduleDTO.setFrontEndPath(applicationModuleEntity.getFrontendRoutePath());
        return moduleDTO;
    }
}
