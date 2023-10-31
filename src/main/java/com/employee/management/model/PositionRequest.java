package com.employee.management.model;

import com.employee.management.entity.Department;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class PositionRequest {
    private String name;
    private double salary;

    private Department department;
}
