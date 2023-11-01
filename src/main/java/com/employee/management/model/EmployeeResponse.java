package com.employee.management.model;


import com.employee.management.entity.Department;
import com.employee.management.entity.Employee;
import com.employee.management.entity.Position;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class EmployeeResponse {
    private int id;
    private String name;
    private String surname;
    private String email;
    private boolean status;


}
