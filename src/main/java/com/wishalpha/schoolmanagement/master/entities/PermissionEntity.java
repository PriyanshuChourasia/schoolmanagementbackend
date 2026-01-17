package com.wishalpha.schoolmanagement.master.entities;

import com.wishalpha.schoolmanagement.common.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "permissions")
public class PermissionEntity extends BaseEntity {
    @NotNull(message = "Permission name is required")
    @Column(name = "name",nullable = false, unique = true)
    private String name;

    private String description;

    @Column(name = "api_pattern")
    private String apiPattern;


}

//LOGIN
//        LOGOUT
//REFRESH_TOKEN
//        CHANGE_PASSWORD
//
