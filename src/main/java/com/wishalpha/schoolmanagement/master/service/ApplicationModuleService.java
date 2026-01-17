package com.wishalpha.schoolmanagement.master.service;

import com.wishalpha.schoolmanagement.master.dtos.module.ModuleCreateDTO;
import com.wishalpha.schoolmanagement.master.dtos.module.ModuleDTO;

import java.util.List;

public interface ApplicationModuleService {

    ModuleDTO create(ModuleCreateDTO moduleCreateDTO);

    List<ModuleDTO> getAll();
}
