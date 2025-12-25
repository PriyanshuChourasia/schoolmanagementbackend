package com.wishalpha.schoolmanagement.master.entity;


import com.wishalpha.schoolmanagement.common.entity.BaseEntity;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "organisation_statuses")
@Tag(name = "Organisation Status Schema")
public class OrganisationStatusEntity extends BaseEntity {

    @Column(nullable = false,unique = true)
    private String name;

    @Column(unique = true)
    private String code;

    private String description;
}
