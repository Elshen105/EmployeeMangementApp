package com.employee.management.service.impl;

import com.employee.management.entity.Position;
import com.employee.management.mapper.PositionMapper;
import com.employee.management.model.PositionDto;
import com.employee.management.model.PositionRequest;
import com.employee.management.model.PositionResponse;
import com.employee.management.repository.PositionRepository;
import com.employee.management.service.PositionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PositionServiceImpl implements PositionService {

    private final PositionRepository positionRepository;

    @Override
    public PositionResponse savePosition(PositionRequest request) {
        Position position = PositionMapper.INSTANCE.modelToEntity(request);
        return PositionMapper.INSTANCE.entityToModel(positionRepository.save(position));
    }

    @Override
    public PositionResponse getPosition(int id) {
        var position = positionRepository.findById(id).orElseThrow(()-> new RuntimeException("Position is NotFound"));

        return PositionMapper.INSTANCE.entityToModel(position);
    }

    @Override
    public List<PositionResponse> getAllPosition() {
        List<Position> positions = positionRepository.findAll();
        return PositionMapper.INSTANCE.entityListToModelList(positions);

    }



    @Override
    public void deletePositionById(int id) {
        positionRepository.deleteById(id);
    }
}
