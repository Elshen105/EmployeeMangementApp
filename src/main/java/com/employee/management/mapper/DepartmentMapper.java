package com.employee.management.mapper;


import com.employee.management.entity.Department;
import com.employee.management.model.DepartmentDto;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public abstract class DepartmentMapper {
    public static final DepartmentMapper INSTANCE = Mappers.getMapper(DepartmentMapper.class);

    public abstract Department dtoToEntity(DepartmentDto departmentDto);

    public abstract DepartmentDto entityToDto(Department department);

    public abstract List<DepartmentDto> entityListToDtoList(List<Department> departments);
}
