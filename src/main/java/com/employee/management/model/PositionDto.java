package com.employee.management.model;

import com.employee.management.entity.Department;
import com.employee.management.entity.Employee;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class PositionDto {

    private Long id;

    private String name;
    private double salary;

    private Department department;
    private List<Employee> employees;


}
