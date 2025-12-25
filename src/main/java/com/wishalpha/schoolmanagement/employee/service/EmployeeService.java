package com.wishalpha.schoolmanagement.employee.service;


import com.wishalpha.schoolmanagement.employee.entity.EmployeeEntity;
import com.wishalpha.schoolmanagement.employee.repository.EmployeeRepository;
import com.wishalpha.schoolmanagement.employee.service.Impl.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService implements IEmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<EmployeeEntity> getAll(){
        return employeeRepository.findAll();
    }
}
