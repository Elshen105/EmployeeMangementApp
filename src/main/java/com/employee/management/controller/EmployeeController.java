package com.employee.management.controller;

import com.employee.management.model.EmployeeDto;
import com.employee.management.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("${root.url}/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping()
    public EmployeeDto save(@RequestBody EmployeeDto employeeDto) {
        return employeeService.saveEmployee(employeeDto);
    }

    @GetMapping("/{id}")
    public EmployeeDto getOne(@PathVariable int id) {
        return employeeService.getEmployee(id);
    }

    @GetMapping("/showAllEmployee")
    public List<EmployeeDto> getAllEmployees() {
        return employeeService.getAllEmployee();
    }

    @DeleteMapping("/delete/{id}")
    public void deleteEmployee(@PathVariable int id) {
        employeeService.deleteEmployeeById(id);
    }



}
