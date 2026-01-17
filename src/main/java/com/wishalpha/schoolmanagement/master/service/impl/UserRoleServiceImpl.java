package com.wishalpha.schoolmanagement.master.service.impl;


import com.wishalpha.schoolmanagement.common.exceptionHandler.exceptions.DataAlreadyExistsException;
import com.wishalpha.schoolmanagement.master.dtos.role.CreateRoleDTO;
import com.wishalpha.schoolmanagement.master.dtos.role.RoleDTO;
import com.wishalpha.schoolmanagement.master.entities.RoleEntity;
import com.wishalpha.schoolmanagement.master.mapper.RoleMapper;
import com.wishalpha.schoolmanagement.master.repository.RoleRepository;
import com.wishalpha.schoolmanagement.master.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserRoleServiceImpl implements UserRoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Transactional(readOnly = true)
    @Override
    public List<RoleDTO> getAll(){
        List<RoleEntity> roleEntities = roleRepository.findAll();
        List<RoleDTO> roleDTOS = roleEntities.stream().map(role-> RoleMapper.toRoleDTO(role)).toList();
        return roleDTOS;
    }

    @Override
    public RoleDTO create(CreateRoleDTO createRoleDTO){
        if(roleRepository.existsByName(createRoleDTO.getName())){
            throw new DataAlreadyExistsException("Role already exists");
        }
        RoleEntity role = RoleMapper.toRoleEntity(createRoleDTO);
        RoleEntity createRole = roleRepository.save(role);
        return RoleMapper.toRoleDTO(role);
    }
}
