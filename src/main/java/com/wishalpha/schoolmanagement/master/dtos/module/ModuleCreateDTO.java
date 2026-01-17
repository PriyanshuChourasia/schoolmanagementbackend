package com.wishalpha.schoolmanagement.master.dtos.module;


import com.wishalpha.schoolmanagement.master.utils.enums.ApplicationStatusEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


public record ModuleCreateDTO (
    @NotBlank(message = "Name is required")  String name,
    @NotBlank(message = "Code is required") String code,
    String description,
    @NotNull(message = "Status is required") ApplicationStatusEnum status
){}
