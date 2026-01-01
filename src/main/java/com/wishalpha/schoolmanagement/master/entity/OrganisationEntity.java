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

    public OrganisationStatusEntity getOrganisationStatus() {
        return organisationStatus;
    }

    public void setOrganisationStatus(OrganisationStatusEntity organisationStatus) {
        this.organisationStatus = organisationStatus;
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

    public boolean isBranch() {
        return isBranch;
    }

    public void setBranch(boolean branch) {
        isBranch = branch;
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

    public String getOrganisationSchemaId() {
        return organisationSchemaId;
    }

    public void setOrganisationSchemaId(String organisationSchemaId) {
        this.organisationSchemaId = organisationSchemaId;
    }

    public OrganisationTypeEntity getOrganisationType() {
        return organisationType;
    }

    public void setOrganisationType(OrganisationTypeEntity organisationType) {
        this.organisationType = organisationType;
    }

}
