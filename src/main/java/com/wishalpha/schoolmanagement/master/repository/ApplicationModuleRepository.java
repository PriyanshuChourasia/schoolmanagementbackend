package com.wishalpha.schoolmanagement.master.repository;

import com.wishalpha.schoolmanagement.master.entities.ApplicationModuleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ApplicationModuleRepository extends JpaRepository<ApplicationModuleEntity, UUID> {

}
