package com.employee.management.mapper;

import com.employee.management.entity.Employee;
import com.employee.management.model.EmployeeDto;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public abstract class EmployeeMapper {
    public static final EmployeeMapper INSTANCE = Mappers.getMapper(EmployeeMapper.class);

    public abstract Employee dtoToEntity(EmployeeDto employeeDto);

    public abstract EmployeeDto entityToDto(Employee employee);

    public abstract List<EmployeeDto> entityListToDtoList(List<Employee> employees);


}
