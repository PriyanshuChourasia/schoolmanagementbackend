package com.wishalpha.schoolmanagement.master.repository;

import com.wishalpha.schoolmanagement.master.entities.ApplicationModuleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ApplicationModuleRepository extends JpaRepository<ApplicationModuleEntity, UUID> {
}
