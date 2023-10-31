package com.employee.management.controller;

import com.employee.management.model.PositionRequest;
import com.employee.management.model.PositionResponse;
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
    public PositionResponse save(@RequestBody PositionRequest request) {
        return positionService.savePosition(request);
    }

    @GetMapping("/{id}")
    public PositionResponse getOne(@PathVariable int id) {
        return positionService.getPosition(id);
    }

    @GetMapping("/showAllPosition")
    public List<PositionResponse> getAllPositions() {
        return positionService.getAllPosition();
    }

    @PutMapping("/{id}")
    public PositionResponse updatePosition(@PathVariable int id, @RequestBody PositionRequest request) {
        return positionService.updatePosition(id, request);
    }

    @DeleteMapping("/delete/{id}")
    public void deletePosition(@PathVariable int id) {
        positionService.deletePositionById(id);
    }



}
