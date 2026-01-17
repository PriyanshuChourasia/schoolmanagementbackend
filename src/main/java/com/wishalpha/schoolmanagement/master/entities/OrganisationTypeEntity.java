package com.wishalpha.schoolmanagement.master.entities;


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
@Table(name = "organisation_types")
@Tag(name = "Organisation Type Schema")
public class OrganisationTypeEntity extends BaseEntity {

    @Column(nullable = false,unique = true)
    private String name;

    @Column(unique = true)
    private String code;

    private String description;


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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
