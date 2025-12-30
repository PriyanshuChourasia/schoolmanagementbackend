package com.wishalpha.schoolmanagement.master.service;

import com.wishalpha.schoolmanagement.master.dto.CreateUserDTO;
import com.wishalpha.schoolmanagement.master.dto.UserDTO;

import java.util.List;

public interface UserService {

    UserDTO create(CreateUserDTO createUserDTO);

    List<UserDTO> getAll();
}
