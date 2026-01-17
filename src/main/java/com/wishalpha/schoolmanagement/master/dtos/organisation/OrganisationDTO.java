package com.wishalpha.schoolmanagement.master.dtos.organisation;


import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class OrganisationDTO {

    private String name;

    private String code;

    private LocalDate establishmentYear;

    private LocalDate terminationYear;

    private UUID organisationSchemaId;

    public String organisationStatus;

    public String organisationType;

    private List<OrganisationDTO> organisationDTOS;

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

    public List<OrganisationDTO> getOrganisationDTOS() {
        return organisationDTOS;
    }

    public void setOrganisationDTOS(List<OrganisationDTO> organisationDTOS) {
        this.organisationDTOS = organisationDTOS;
    }

}
