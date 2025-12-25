package com.wishalpha.schoolmanagement.master.repository;

import com.wishalpha.schoolmanagement.master.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity,Long> {

    UserEntity findByEmail(String email);
}
