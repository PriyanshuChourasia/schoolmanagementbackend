package com.wishalpha.schoolmanagement.auth.service.impl;


import com.wishalpha.schoolmanagement.master.entity.UserEntity;
import com.wishalpha.schoolmanagement.master.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService {

    private final Logger logger = LoggerFactory.getLogger(CustomUserDetailService.class);

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        UserEntity userEntity = userRepository.findByEmail(username);
        logger.error("Entity: {}",userEntity);
        if(userEntity == null){
            throw new UsernameNotFoundException("Email not found: "+ username);
        }
        return User.builder()
                .username(userEntity.getEmail())
                .password(userEntity.getPassword())
                .build();
    }
}
