package com.employee.management.service.impl;

import com.employee.management.entity.Employee;
import com.employee.management.mapper.EmployeeMapper;
import com.employee.management.model.EmployeeDto;
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
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.INSTANCE.dtoToEntity(employeeDto);
        return EmployeeMapper.INSTANCE.entityToDto(employeeRepository.save(employee));
    }

    @Override
    public List<EmployeeDto> getAllEmployee() {
        List<Employee> employees = employeeRepository.findAll();
        return EmployeeMapper.INSTANCE.entityListToDtoList(employees);

    }

    @Override
    public EmployeeDto getEmployee(int id) {
        var employee = employeeRepository.findById(id).orElseThrow(()-> new RuntimeException("Employee NotFound"));

        return EmployeeMapper.INSTANCE.entityToDto(employee);
    }

    @Override
    public void deleteEmployeeById(int id) {
        employeeRepository.deleteById(id);
    }




}
