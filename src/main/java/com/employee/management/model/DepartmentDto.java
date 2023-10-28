package com.employee.management.model;

import com.employee.management.entity.Employee;
import com.employee.management.entity.Position;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class DepartmentDto {
    private String name;
}
