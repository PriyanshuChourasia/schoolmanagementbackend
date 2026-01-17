package com.wishalpha.schoolmanagement.master.mapper;

import com.wishalpha.schoolmanagement.master.dtos.role.CreateRoleDTO;
import com.wishalpha.schoolmanagement.master.dtos.role.RoleDTO;
import com.wishalpha.schoolmanagement.master.entities.RoleEntity;

public class RoleMapper {

    public static RoleEntity toRoleEntity(CreateRoleDTO createRoleDTO){
        RoleEntity role = new RoleEntity();
        role.setName(createRoleDTO.getName());
        role.setName(createRoleDTO.getDescription());
        return role;
    }

    public static RoleDTO toRoleDTO(RoleEntity roleEntity){
        RoleDTO roleDTO = new RoleDTO();
        roleDTO.setName(roleEntity.getName());
        roleDTO.setDescription(roleEntity.getDescription());
        return roleDTO;
    }
}
