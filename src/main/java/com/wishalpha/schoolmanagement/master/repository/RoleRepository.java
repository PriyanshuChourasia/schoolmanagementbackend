package com.wishalpha.schoolmanagement.master.repository;

import com.wishalpha.schoolmanagement.master.entities.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RoleRepository extends JpaRepository<RoleEntity, UUID> {
    boolean existsByName(String name);
}
