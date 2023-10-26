package com.employee.management.controller;

import com.employee.management.model.PositionDto;
import com.employee.management.service.PositionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("${root.url}/positions")
public class PositionController {

    private final PositionService positionService;

    @PostMapping()
    public PositionDto save(@RequestBody PositionDto positionDto) {
        return positionService.savePosition(positionDto);
    }

    @GetMapping("/{id}")
    public PositionDto getOne(@PathVariable int id) {
        return positionService.getPosition(id);
    }

    @GetMapping("/showAllPosition")
    public List<PositionDto> getAllPositions() {
        return positionService.getAllPosition();
    }

    @DeleteMapping("/delete/{id}")
    public void deletePosition(@PathVariable int id) {
        positionService.deletePositionById(id);
    }



}
