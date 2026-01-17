package com.wishalpha.schoolmanagement.master.entities;


import com.wishalpha.schoolmanagement.common.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table(name = "user_auth_logs")
public class UserAuthLog extends BaseEntity {

    @Column(name = "user_id", nullable = false)
    public Long userId;

    @Column(name = "login_time")
    public LocalDateTime loginTime;

    @Column(name = "logout_time")
    public LocalDateTime logoutTime;

    @Column(name = "ip_address")
    public String ipAddress;



    @PrePersist
    public void onCreate(){
        this.loginTime = LocalDateTime.now();
    }
}
