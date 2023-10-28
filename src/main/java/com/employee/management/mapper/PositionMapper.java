package com.employee.management.mapper;


import com.employee.management.entity.Department;
import com.employee.management.entity.Position;
import com.employee.management.model.*;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public abstract class PositionMapper {
    public static final PositionMapper INSTANCE = Mappers.getMapper(PositionMapper.class);


    public abstract Position modelToEntity(PositionRequest request);

    public abstract PositionResponse entityToModel(Position position);

    public abstract List<PositionResponse> entityListToModelList(List<Position> positions);




    public abstract Position dtoToEntity(PositionDto positionDto);

    public abstract PositionDto entityToDto(Position position);

    public abstract List<PositionDto> entityListToDtoList(List<Position> positions);
}
