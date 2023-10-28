package com.employee.management.controller;

import com.employee.management.model.DepartmentDto;
import com.employee.management.model.DepartmentRequest;
import com.employee.management.model.DepartmentResponse;
import com.employee.management.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("${root.url}/departments")
public class DepartmentController {

    private final DepartmentService departmentService;

    @PostMapping()
    public DepartmentResponse save(@RequestBody DepartmentRequest request) {
        return departmentService.saveDepartment(request);
    }

    @GetMapping("/{id}")
    public DepartmentResponse getOne(@PathVariable int id) {
        return departmentService.getDepartment(id);
    }

    @GetMapping("/showAllDepartment")
    public List<DepartmentResponse> getAllDepartments() {
        return departmentService.getAllDepartment();
    }

    @DeleteMapping("/delete/{id}")
    public void deleteDepartment(@PathVariable int id) {
        departmentService.deleteDepartmentById(id);
    }



}
