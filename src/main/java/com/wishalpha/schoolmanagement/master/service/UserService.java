package com.wishalpha.schoolmanagement.master.service;

import com.wishalpha.schoolmanagement.master.dtos.user.CreateUserDTO;
import com.wishalpha.schoolmanagement.master.dtos.user.UserDTO;

import java.util.List;

public interface UserService {

    UserDTO create(CreateUserDTO createUserDTO);

    List<UserDTO> getAll();

    UserDTO getByEmail(String email);
}
