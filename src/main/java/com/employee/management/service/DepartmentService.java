package com.employee.management.service;

import com.employee.management.model.DepartmentDto;

import java.util.List;

public interface DepartmentService {
    DepartmentDto saveDepartment(DepartmentDto departmentDto);

    DepartmentDto getDepartment(int id);

    List<DepartmentDto> getAllDepartment();

    void deleteDepartmentById(int id);
}
