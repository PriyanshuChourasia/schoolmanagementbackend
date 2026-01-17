package com.wishalpha.schoolmanagement.master.service.impl;


import com.wishalpha.schoolmanagement.common.exceptionHandler.exceptions.DataNotFoundException;
import com.wishalpha.schoolmanagement.master.dtos.user.CreateUserDTO;
import com.wishalpha.schoolmanagement.master.dtos.user.UserDTO;
import com.wishalpha.schoolmanagement.master.entities.UserEntity;
import com.wishalpha.schoolmanagement.master.mapper.UserMapper;
import com.wishalpha.schoolmanagement.master.repository.UserRepository;
import com.wishalpha.schoolmanagement.master.service.UserService;
import com.wishalpha.schoolmanagement.master.utils.CodeGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final static Logger logger = LoggerFactory.getLogger(UserService.class);
    @Autowired
    private  UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private CodeGenerator codeGenerator;

    @Transactional(readOnly = true)
    @Override
    public List<UserDTO> getAll(){
        List<UserEntity> userEntities = userRepository.findAll();
        List<UserDTO> userDTOS = userEntities.stream().map(UserMapper::toDTO).toList();
        return userDTOS;
    }


    @Override
    public UserDTO create(CreateUserDTO createUserDTO){
        UserEntity user = UserMapper.toEntity(createUserDTO);
        user.setPassword(passwordEncoder.encode("1234567890"));
        user.setCode(codeGenerator.generateCode(createUserDTO.getEmail()));
        UserEntity createUser = userRepository.save(user);
        return UserMapper.toDTO(createUser);
    }

    @Override
    public UserDTO getByEmail(String email){
        UserEntity user = userRepository.findByEmail(email);
        if(user == null){
            throw new DataNotFoundException("User not found: " + email);
        }
        return UserMapper.toDTO(user);
    }
}
