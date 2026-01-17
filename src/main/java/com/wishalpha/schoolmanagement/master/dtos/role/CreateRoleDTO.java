package com.wishalpha.schoolmanagement.master.dtos.role;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

public class CreateRoleDTO {

    @Schema(example = "ADMIN")
    @NotBlank(message = "Name is required")
    private String name;

    @Schema(example = "Admin can do everything")
    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
