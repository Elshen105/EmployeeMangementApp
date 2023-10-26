package com.employee.management.model;

import com.employee.management.entity.Department;
import com.employee.management.entity.Position;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class EmployeeDto {

    private Long id;

    private String name;
    private String surname;
    private String email;

    private boolean status;

    private Department department;
    private Position position;

}
