package com.wishalpha.schoolmanagement.master.service;

import com.wishalpha.schoolmanagement.master.dtos.role.CreateRoleDTO;
import com.wishalpha.schoolmanagement.master.dtos.role.RoleDTO;

import java.util.List;

public interface UserRoleService {

    List<RoleDTO> getAll();
    RoleDTO create(CreateRoleDTO createRoleDTO);
}
