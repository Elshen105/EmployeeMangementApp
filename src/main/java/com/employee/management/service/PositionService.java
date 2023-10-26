package com.employee.management.service;

import com.employee.management.model.EmployeeDto;
import com.employee.management.model.PositionDto;

import java.util.List;

public interface PositionService {
    PositionDto savePosition(PositionDto positionDto);
    List<PositionDto> getAllPosition();

    PositionDto getPosition(int id);

    void deletePositionById(int id);

}
