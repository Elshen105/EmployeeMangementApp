package com.employee.management.service.impl;

import com.employee.management.entity.Department;
import com.employee.management.entity.Employee;
import com.employee.management.entity.Position;
import com.employee.management.model.DepartmentRequest;
import com.employee.management.model.EmployeeRequest;
import com.employee.management.model.EmployeeResponse;
import com.employee.management.model.PositionRequest;
import com.employee.management.repository.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
class EmployeeServiceImplTest {

    @Mock
    private EmployeeRepository employeeRepository;

    @InjectMocks
    private EmployeeServiceImpl employeeService;
    @Test
    void saveEmployee() {
        // given
        int employeeId = 1;
        int departmentId = 1;
        int positionId = 1;

        Department itDepartment = Department.builder().id(departmentId).name("IT Department").build();
        Position positionItCoordinator = Position.builder().id(positionId).name("IT Coordinator").salary(60000).build();
        EmployeeRequest employeeRequest = new EmployeeRequest("Asif", "Elekberov", "ae@gmail.com", true, itDepartment, positionItCoordinator);

        Employee employee = Employee.builder().id(employeeId).name("Asif").surname("Elekberov").email("ae@gmail.com").status(true).department(itDepartment).position(positionItCoordinator).build();


        // when
        when(employeeRepository.save(any(Employee.class))).thenReturn(employee);
        EmployeeResponse employeeResponse = employeeService.saveEmployee(employeeRequest);

        //then
        assertNotNull(employeeResponse);


    }



}