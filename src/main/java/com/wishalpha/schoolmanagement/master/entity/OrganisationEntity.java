package com.wishalpha.schoolmanagement.master.entity;

import com.wishalpha.schoolmanagement.common.entity.BaseEntity;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "organisations")
@Tag(name = "Organisation Schema")
public class OrganisationEntity extends BaseEntity {

    @Column(nullable = false,unique = true)
    private String name;

    @Column(unique = true)
    private String code;

    @Column(name = "is_branch", nullable = false)
    private boolean isBranch = false;

    @Column(name = "establishment_year", nullable = false)
    private LocalDate establishmentYear;

    @Column(name = "termination_year")
    private LocalDate terminationYear;

    @Column(name = "organisation_schema_id")
    private String organisationSchemaId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "organisation_status_id", nullable = false)
    private OrganisationStatusEntity organisationStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "organisation_type_id",nullable = false)
    private OrganisationTypeEntity organisationType;
}
