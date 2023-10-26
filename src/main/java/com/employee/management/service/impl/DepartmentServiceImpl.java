package com.employee.management.service.impl;

import com.employee.management.entity.Department;
import com.employee.management.mapper.DepartmentMapper;
import com.employee.management.model.DepartmentDto;
import com.employee.management.repository.DepartmentRepository;
import com.employee.management.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentRepository employeeRepository;

    @Override
    public DepartmentDto saveDepartment(DepartmentDto employeeDto) {
        Department employee = DepartmentMapper.INSTANCE.dtoToEntity(employeeDto);
        return DepartmentMapper.INSTANCE.entityToDto(employeeRepository.save(employee));
    }

    @Override
    public List<DepartmentDto> getAllDepartment() {
        List<Department> employees = employeeRepository.findAll();
        return DepartmentMapper.INSTANCE.entityListToDtoList(employees);

    }

    @Override
    public DepartmentDto getDepartment(int id) {
        var employee = employeeRepository.findById(id).orElseThrow(()-> new RuntimeException("Department is NotFound"));

        return DepartmentMapper.INSTANCE.entityToDto(employee);
    }

    @Override
    public void deleteDepartmentById(int id) {
        employeeRepository.deleteById(id);
    }



}
