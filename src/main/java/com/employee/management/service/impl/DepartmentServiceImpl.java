package com.employee.management.service.impl;

import com.employee.management.entity.Department;
import com.employee.management.mapper.DepartmentMapper;
import com.employee.management.model.DepartmentRequest;
import com.employee.management.model.DepartmentResponse;
import com.employee.management.repository.DepartmentRepository;
import com.employee.management.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentRepository departmentRepository;

    @Override
    public DepartmentResponse saveDepartment(DepartmentRequest request) {
        Department employee = DepartmentMapper.INSTANCE.modelToEntity(request);
        return DepartmentMapper.INSTANCE.entityToModel(departmentRepository.save(employee));
    }

    @Override
    public List<DepartmentResponse> getAllDepartment() {
        List<Department> employees = departmentRepository.findAll();
        return DepartmentMapper.INSTANCE.entityListToModelList(employees);

    }

    @Override
    public DepartmentResponse getDepartment(int id) {
        var employee = departmentRepository.findById(id).orElseThrow(()-> new RuntimeException("Department is NotFound id :" + id));

        return DepartmentMapper.INSTANCE.entityToModel(employee);
    }


    @Override
    public void deleteDepartmentById(int id) {
        departmentRepository.deleteById(id);
    }



}
