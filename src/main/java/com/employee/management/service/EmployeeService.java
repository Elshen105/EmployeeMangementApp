package com.employee.management.service;

import com.employee.management.model.EmployeeDto;

import java.util.List;


public interface EmployeeService {
    EmployeeDto saveEmployee(EmployeeDto employeeDto);
    List<EmployeeDto> getAllEmployee();

    EmployeeDto getEmployee(int id);

    void deleteEmployeeById(int id);


}
