package com.wishalpha.schoolmanagement.master.dtos.module;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.wishalpha.schoolmanagement.master.utils.enums.ApplicationStatusEnum;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ModuleDTO {
    private String name;
    private String code;
    private String description;
    private ApplicationStatusEnum status;
}
