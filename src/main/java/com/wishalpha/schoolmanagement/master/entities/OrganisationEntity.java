package com.wishalpha.schoolmanagement.master.entities;

import com.wishalpha.schoolmanagement.common.entity.BaseEntity;
import com.wishalpha.schoolmanagement.master.utils.enums.OrganisationStatusEnum;
import com.wishalpha.schoolmanagement.master.utils.enums.OrganisationTypeEnum;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;


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

    @ManyToOne
    @JoinColumn(name = "parent_organisation_id")
    private OrganisationEntity parentOrganisation;

    @Column(name = "establishment_year", nullable = false)
    private LocalDate establishmentYear;

    @Column(name = "termination_year")
    private LocalDate terminationYear;

    @Column(name = "organisation_schema_id")
    private UUID organisationSchemaId;

    @Enumerated(EnumType.STRING)
    @Column(name = "organisation_status", nullable = false)
    private OrganisationStatusEnum organisationStatus;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "organisation_type_id",nullable = false)
//    private OrganisationTypeEntity organisationType;

    @Enumerated(EnumType.STRING)
    @Column(name = "organisation_type")
    private OrganisationTypeEnum organisationTypeEnum;

    public OrganisationEntity getParentOrganisation() {
        return parentOrganisation;
    }

    public void setParentOrganisation(OrganisationEntity parentOrganisation) {
        this.parentOrganisation = parentOrganisation;
    }

    public OrganisationStatusEnum getOrganisationStatus() {
        return organisationStatus;
    }

    public void setOrganisationStatus(OrganisationStatusEnum organisationStatus) {
        this.organisationStatus = organisationStatus;
    }

    public OrganisationTypeEnum getOrganisationTypeEnum() {
        return organisationTypeEnum;
    }

    public void setOrganisationTypeEnum(OrganisationTypeEnum organisationTypeEnum) {
        this.organisationTypeEnum = organisationTypeEnum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public LocalDate getEstablishmentYear() {
        return establishmentYear;
    }

    public void setEstablishmentYear(LocalDate establishmentYear) {
        this.establishmentYear = establishmentYear;
    }

    public LocalDate getTerminationYear() {
        return terminationYear;
    }

    public void setTerminationYear(LocalDate terminationYear) {
        this.terminationYear = terminationYear;
    }

    public UUID getOrganisationSchemaId() {
        return organisationSchemaId;
    }

    public void setOrganisationSchemaId(UUID organisationSchemaId) {
        this.organisationSchemaId = organisationSchemaId;
    }

}
