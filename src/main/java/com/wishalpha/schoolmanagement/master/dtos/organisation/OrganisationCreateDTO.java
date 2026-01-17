package com.wishalpha.schoolmanagement.master.dtos.organisation;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.UUID;

public class OrganisationCreateDTO {

    @NotBlank(message = "Name is required")
    @NotNull(message = "Name cannot be null")
    private String name;

    private String code;

    @NotNull(message = "Establishment year cannot not null")
    private LocalDate establishmentYear;

    @NotNull(message = "Termination year cannot be null")
    private LocalDate terminationYear;

    private String organisationStatus;

    private String organisationType;

    private UUID parentOrganisationId;

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

    public UUID getParentOrganisationId() {
        return parentOrganisationId;
    }

    public void setParentOrganisationId(UUID parentOrganisationId) {
        this.parentOrganisationId = parentOrganisationId;
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

    public String getOrganisationStatus() {
        return organisationStatus;
    }

    public void setOrganisationStatus(String organisationStatus) {
        this.organisationStatus = organisationStatus;
    }

    public String getOrganisationType() {
        return organisationType;
    }

    public void setOrganisationType(String organisationType) {
        this.organisationType = organisationType;
    }
}
