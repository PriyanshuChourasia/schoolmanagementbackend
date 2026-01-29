package com.wishalpha.schoolmanagement.master.entities;


import com.wishalpha.schoolmanagement.common.entity.BaseEntity;
import com.wishalpha.schoolmanagement.master.utils.enums.ApplicationStatusEnum;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "application_module_features")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Tag(name= "Application Features")
public class ApplicationModuleFeatureEntity extends BaseEntity {

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "code",unique = true, nullable = false)
    private String code;

    @Column(name = "description")
    private String description;

    @Column(name = "api_path")
    private String apiPath;

    @Enumerated(EnumType.STRING)
    @Column(name = "status",nullable = false)
    private ApplicationStatusEnum status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "module_id", nullable = false)
    private ApplicationModuleEntity module;
}