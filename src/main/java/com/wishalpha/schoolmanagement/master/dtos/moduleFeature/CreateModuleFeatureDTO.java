package com.wishalpha.schoolmanagement.master.dtos.moduleFeature;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.wishalpha.schoolmanagement.master.utils.enums.ApplicationStatusEnum;
import jakarta.validation.constraints.NotBlank;

import java.util.UUID;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record CreateModuleFeatureDTO(
        @NotBlank(message = "Name is required")
        String name,
        @NotBlank(message = "Code is required to place it unique")
        String code,

        String description,

        @NotBlank(message = "Api path has to mentioned")
        String apiPath,

        ApplicationStatusEnum status,

        @NotBlank(message = "Module id is required")
        UUID module
){}
