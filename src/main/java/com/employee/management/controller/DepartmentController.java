package com.employee.management.controller;

import com.employee.management.model.DepartmentDto;
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
    public DepartmentDto save(@RequestBody DepartmentDto departmentDto) {
        return departmentService.saveDepartment(departmentDto);
    }

    @GetMapping("/{id}")
    public DepartmentDto getOne(@PathVariable int id) {
        return departmentService.getDepartment(id);
    }

    @GetMapping("/showAllDepartment")
    public List<DepartmentDto> getAllDepartments() {
        return departmentService.getAllDepartment();
    }

    @DeleteMapping("/delete/{id}")
    public void deleteDepartment(@PathVariable int id) {
        departmentService.deleteDepartmentById(id);
    }



}
