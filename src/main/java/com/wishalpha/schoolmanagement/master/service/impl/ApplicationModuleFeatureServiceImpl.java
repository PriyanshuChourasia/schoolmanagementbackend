package com.wishalpha.schoolmanagement.master.service.impl;


import com.wishalpha.schoolmanagement.common.exceptionHandler.exceptions.DataAlreadyExistsException;
import com.wishalpha.schoolmanagement.common.exceptionHandler.exceptions.DataNotFoundException;
import com.wishalpha.schoolmanagement.master.dtos.moduleFeature.CreateModuleFeatureDTO;
import com.wishalpha.schoolmanagement.master.dtos.moduleFeature.ModuleFeatureDTO;
import com.wishalpha.schoolmanagement.master.entities.ApplicationModuleEntity;
import com.wishalpha.schoolmanagement.master.entities.ApplicationModuleFeatureEntity;
import com.wishalpha.schoolmanagement.master.mapper.ApplicationModuleFeatureMapper;
import com.wishalpha.schoolmanagement.master.repository.ApplicationModuleFeatureRepository;
import com.wishalpha.schoolmanagement.master.repository.ApplicationModuleRepository;
import com.wishalpha.schoolmanagement.master.service.ApplicationModuleFeatureService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ApplicationModuleFeatureServiceImpl implements ApplicationModuleFeatureService {

    private final ApplicationModuleFeatureRepository applicationModuleFeatureRepository;
    private final ApplicationModuleRepository applicationModuleRepository;

    @Override
    public ModuleFeatureDTO create(CreateModuleFeatureDTO createModuleFeatureDTO){
        if(applicationModuleFeatureRepository.findByCode(createModuleFeatureDTO.code()) != null){
            throw new DataAlreadyExistsException("Application Module Feature code exists");
        }

        ApplicationModuleEntity applicationModule = applicationModuleRepository.findById(createModuleFeatureDTO.module()).orElseThrow(
                () -> new DataNotFoundException("Module not found")
        );
        ApplicationModuleFeatureEntity createFeatureModule = ApplicationModuleFeatureMapper.toEntity(createModuleFeatureDTO,applicationModule);

        return ApplicationModuleFeatureMapper.toDTO(createFeatureModule);

    }
}
