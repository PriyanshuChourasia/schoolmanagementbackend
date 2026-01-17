package com.wishalpha.schoolmanagement.master.utils;

import com.wishalpha.schoolmanagement.auth.entity.UserPrincipal;
import com.wishalpha.schoolmanagement.common.entity.BaseEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.UUID;

public final class AuditorAwareUtil{
    private final static Logger logger = LoggerFactory.getLogger(AuditorAwareUtil.class);
    public AuditorAwareUtil(){}

    public static UUID getCurrentAuditor(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        Object principal = authentication.getPrincipal();

        logger.info("Principal: {}",principal);
        logger.info("Principal: {}",principal instanceof UserPrincipal);
        logger.info("Principal: {}",SecurityContextHolder.getContext().getAuthentication().getName());

        if(principal instanceof UserPrincipal userPrincipal){
            return userPrincipal.getId();
        }
        return null;
    }
}
