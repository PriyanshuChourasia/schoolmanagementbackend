package com.wishalpha.schoolmanagement.master.seeders;


import com.wishalpha.schoolmanagement.common.utils.enums.Gender;
import com.wishalpha.schoolmanagement.master.entities.UserEntity;
import com.wishalpha.schoolmanagement.master.repository.UserRepository;
import com.wishalpha.schoolmanagement.master.utils.enums.AccountStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@Order(1)
public class UserSeeder {

    @Autowired
    private UserRepository userRepository;

    private PasswordEncoder passwordEncoder;

    public UserSeeder(){}

    public void seedUsers(){
        UserEntity admin = new UserEntity();
        admin.setName("Priyanshu Chourasia");
        admin.setCode("PRI-001");
        admin.setDob(LocalDate.now());
        admin.setAccountStatus(AccountStatus.ACTIVE);
        admin.setEmail("admin@admin.com");
        admin.setGender(Gender.MALE);
        admin.setPassword(passwordEncoder.encode("1234567890"));
        userRepository.save(admin);
    }

}
