package com.employee.management.service.impl;

import com.employee.management.entity.Employee;
import com.employee.management.entity.Position;
import com.employee.management.mapper.EmployeeMapper;
import com.employee.management.mapper.PositionMapper;
import com.employee.management.model.PositionDto;
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
    public PositionDto savePosition(PositionDto positionDto) {
        Position position = PositionMapper.INSTANCE.dtoToEntity(positionDto);
        return PositionMapper.INSTANCE.entityToDto(positionRepository.save(position));
    }

    @Override
    public List<PositionDto> getAllPosition() {
        List<Position> positions = positionRepository.findAll();
        return PositionMapper.INSTANCE.entityListToDtoList(positions);

    }

    @Override
    public PositionDto getPosition(int id) {
        var position = positionRepository.findById(id).orElseThrow(()-> new RuntimeException("Position is NotFound"));

        return PositionMapper.INSTANCE.entityToDto(position);
    }

    @Override
    public void deletePositionById(int id) {
        positionRepository.deleteById(id);
    }
}
