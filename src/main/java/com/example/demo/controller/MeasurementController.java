package com.example.demo.controller;

import com.example.demo.controller.dto.SugarMeasurementDTO;
import com.example.demo.service.MeasurementService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MeasurementController {
    public MeasurementService measurementService;

    public MeasurementController(MeasurementService measurementService) {
        this.measurementService = measurementService;
    }

    @PostMapping(path = "/sugar/measurement")
    public List<SugarMeasurementDTO> saveSugarMeasurement(@RequestBody SugarMeasurementDTO measurementDTO) {
        return measurementService.saveSugarMeasurement(measurementDTO);
    }

    @GetMapping(path = "/sugar/measurement")
    public List<SugarMeasurementDTO> getSugarMeasurements() {
        return measurementService.getSugarMeasurements();
    }

    @DeleteMapping(path = "/sugar/measurement/{index}")
    public SugarMeasurementDTO deleteMeasurement(@PathVariable("index") Integer index) {
        return measurementService.deleteMeasurement(index);
    }
}
