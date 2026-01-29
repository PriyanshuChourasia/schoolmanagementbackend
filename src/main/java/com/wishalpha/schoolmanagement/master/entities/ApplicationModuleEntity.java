package com.wishalpha.schoolmanagement.master.entities;


import com.wishalpha.schoolmanagement.common.entity.BaseEntity;
import com.wishalpha.schoolmanagement.master.utils.enums.ApplicationStatusEnum;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "application_modules")
@Tag(name ="Application Module")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ApplicationModuleEntity extends BaseEntity {

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String code;

    private String description;

    @Column(name = "frontend_route_path")
    private String frontendRoutePath;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ApplicationStatusEnum status;

    @OneToMany(
            mappedBy = "module",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    private List<ApplicationModuleFeatureEntity> features;
}
