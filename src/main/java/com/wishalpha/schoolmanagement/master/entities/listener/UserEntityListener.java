package com.wishalpha.schoolmanagement.master.entities.listener;

import com.wishalpha.schoolmanagement.master.entities.UserEntity;
import jakarta.persistence.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserEntityListener {
    private final static Logger logger = LoggerFactory.getLogger(UserEntityListener.class);


    @PrePersist
    @PreUpdate
    @PreRemove
    private void beforeAnyUpdate(UserEntity user){
        if(user.getId().toString().isBlank()){
            logger.info("[USER] About to add user");
        }else{
            logger.info("[USER] About to update/delete user: {}",user.getId());
        }
    }


    @PostPersist
    @PostUpdate
    @PostRemove
    private void afterAnyUpdate(UserEntity user){
        logger.info("[USER] add update delete complete for user");
    }

    @PostLoad
    private void afterLoad(UserEntity user){
        logger.info("[USER] user loaded from database: {}",user.getId());
    }
}
