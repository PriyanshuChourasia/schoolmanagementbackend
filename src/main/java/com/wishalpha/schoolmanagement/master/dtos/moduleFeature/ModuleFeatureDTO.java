package com.wishalpha.schoolmanagement.master.dtos.moduleFeature;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ModuleFeatureDTO {
    private String name;
    private String code;
    private String description;
    private String status;
//    private ModuleDTO module;
}
