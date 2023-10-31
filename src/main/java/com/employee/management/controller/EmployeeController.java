package com.employee.management.controller;

import com.employee.management.model.EmployeeRequest;
import com.employee.management.model.EmployeeResponse;
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
    public EmployeeResponse save(@RequestBody EmployeeRequest request) {
        return employeeService.saveEmployee(request);
    }

    @GetMapping("/{id}")
    public EmployeeResponse getOne(@PathVariable int id) {
        return employeeService.getEmployee(id);
    }

    @GetMapping("/showAllEmployee")
    public List<EmployeeResponse> getAllEmployees() {
        return employeeService.getAllEmployee();
    }


    @PutMapping("/{id}")
    public EmployeeResponse updateEmployee(@PathVariable int id, @RequestBody EmployeeRequest request) {
        return employeeService.updateEmployee(id, request);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteEmployee(@PathVariable int id) {
        employeeService.deleteEmployeeById(id);
    }



}
