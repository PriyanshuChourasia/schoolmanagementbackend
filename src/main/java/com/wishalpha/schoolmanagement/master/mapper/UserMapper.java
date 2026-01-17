package com.wishalpha.schoolmanagement.master.mapper;

import com.wishalpha.schoolmanagement.master.dtos.user.CreateUserDTO;
import com.wishalpha.schoolmanagement.master.dtos.user.UserDTO;
import com.wishalpha.schoolmanagement.master.entities.UserEntity;


public class UserMapper {
    public static UserEntity toEntity(CreateUserDTO createUserDTO){
        UserEntity user = new UserEntity();
        user.setName(createUserDTO.getName());
        user.setEmail(createUserDTO.getEmail());
        user.setContactNo(createUserDTO.getContactNo());
        user.setDob(createUserDTO.getDob());
        user.setGender(createUserDTO.getGender());
        user.setActive(true);
        user.setAltContactNo(createUserDTO.getAltContactNo());
        return user;
    }

    public static UserDTO toDTO(UserEntity user){
        UserDTO userDTO = new UserDTO();
        userDTO.setName(user.getName());
        userDTO.setActive(user.isActive());
        userDTO.setDob(user.getDob());
        userDTO.setCode(user.getCode());
        userDTO.setContactNo(user.getContactNo());
        userDTO.setAltContactNo(user.getAltContactNo());
        userDTO.setEmail(user.getEmail());
        userDTO.setGender(user.getGender());
        return userDTO;
    }
}
