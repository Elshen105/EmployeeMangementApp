package com.employee.management.service;

import com.employee.management.model.PositionDto;
import com.employee.management.model.PositionRequest;
import com.employee.management.model.PositionResponse;

import java.util.List;

public interface PositionService {
    PositionResponse savePosition(PositionRequest request);


    PositionResponse getPosition(int id);

    List<PositionResponse> getAllPosition();


    void deletePositionById(int id);

}
