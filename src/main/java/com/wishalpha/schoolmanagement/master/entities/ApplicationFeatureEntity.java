package com.wishalpha.schoolmanagement.master.entities;


import com.wishalpha.schoolmanagement.common.entity.BaseEntity;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "application_features")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Tag(name= "Application Features")
public class ApplicationFeatureEntity extends BaseEntity {

    @Column(name = "name",unique = true, nullable = false)
    private String name;

    @Column(name = "code",unique = true, nullable = false)
    private String code;

    @Column(name = "description")
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "module_id", nullable = false)
    private ApplicationModuleEntity module;
}


//AUTH
//        USER_MANAGEMENT
//ROLE_MANAGEMENT
//        TENANT_MANAGEMENT
//BRANCH_MANAGEMENT