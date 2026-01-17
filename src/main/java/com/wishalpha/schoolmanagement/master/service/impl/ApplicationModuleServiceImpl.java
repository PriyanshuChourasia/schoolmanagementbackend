package com.wishalpha.schoolmanagement.master.service.impl;


import com.wishalpha.schoolmanagement.master.dtos.module.ModuleCreateDTO;
import com.wishalpha.schoolmanagement.master.dtos.module.ModuleDTO;
import com.wishalpha.schoolmanagement.master.entities.ApplicationModuleEntity;
import com.wishalpha.schoolmanagement.master.mapper.ApplicationModuleMapper;
import com.wishalpha.schoolmanagement.master.repository.ApplicationModuleRepository;
import com.wishalpha.schoolmanagement.master.service.ApplicationModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicationModuleServiceImpl implements ApplicationModuleService {

    @Autowired
    private ApplicationModuleRepository applicationModuleRepository;


    @Override
    public List<ModuleDTO> getAll(){
        List<ApplicationModuleEntity> applicationModuleEntities = applicationModuleRepository.findAll();
        List<ModuleDTO> moduleDTOS = applicationModuleEntities.stream().map(ApplicationModuleMapper::toDTO).toList();
        return moduleDTOS;
    }

    @Override
    public ModuleDTO create(ModuleCreateDTO moduleCreateDTO){
       ApplicationModuleEntity applicationModule = ApplicationModuleMapper.toEntity(moduleCreateDTO);
       ApplicationModuleEntity applicationModuleEntity = applicationModuleRepository.save(applicationModule);
       ModuleDTO moduleDTO = ApplicationModuleMapper.toDTO(applicationModuleEntity);
       return moduleDTO;
    }
}
