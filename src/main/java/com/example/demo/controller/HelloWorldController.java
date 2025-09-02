package com.example.demo.controller;

import com.example.demo.controller.dto.IndexMeasurementDTO;
import com.example.demo.controller.dto.SugarMeasurementDTO;
import com.example.demo.service.MeasurementService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HelloWorldController {
    public MeasurementService measurementService;

    public HelloWorldController(MeasurementService measurementService) {
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

    @DeleteMapping(path = "/sugar/measurement")
    public SugarMeasurementDTO deleteMeasurement(@RequestBody IndexMeasurementDTO indexDTO) {
        return measurementService.deleteMeasurement(indexDTO);
    }
}
