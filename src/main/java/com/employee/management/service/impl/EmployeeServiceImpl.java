package com.employee.management.service.impl;

import com.employee.management.entity.Employee;
import com.employee.management.exception.NotFoundException;
import com.employee.management.mapper.EmployeeMapper;
import com.employee.management.model.EmployeeRequest;
import com.employee.management.model.EmployeeResponse;
import com.employee.management.repository.EmployeeRepository;
import com.employee.management.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Override
    public EmployeeResponse saveEmployee(EmployeeRequest request) {
        Employee employee = EmployeeMapper.INSTANCE.modelToEntity(request);
        return EmployeeMapper.INSTANCE.entityToModel(employeeRepository.save(employee));
    }

    @Override
    public List<EmployeeResponse> getAllEmployee() {
        List<Employee> employees = employeeRepository.findAll();
        return EmployeeMapper.INSTANCE.entityListToModelList(employees);
    }

    @Override
    public EmployeeResponse getEmployee(int id) {
        var employee = employeeRepository.findById(id).orElseThrow(()-> new RuntimeException("Employee NotFound id: " + id));

        return EmployeeMapper.INSTANCE.entityToModel(employee);
    }

    @Override
    public EmployeeResponse updateEmployee(int id, EmployeeRequest request) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Employee is NotFound id : " + id));

        EmployeeMapper.INSTANCE.modelToEntity(employee, request);
        Employee updatedEmployee = employeeRepository.save(employee);

        return EmployeeMapper.INSTANCE.entityToModel(updatedEmployee);
    }

    @Override
    public void deleteEmployeeById(int id) {
        employeeRepository.deleteById(id);
    }




}
