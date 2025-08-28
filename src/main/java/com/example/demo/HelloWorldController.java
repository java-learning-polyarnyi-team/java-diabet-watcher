package com.example.demo;

import com.example.demo.dto.IndexMeasurementDTO;
import com.example.demo.dto.SugarMeasurementDTO;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class HelloWorldController {
    public List<SugarMeasurementDTO> measurementDTOList = new ArrayList<>();


    @PostMapping(path = "/sugar/measurement")
    public List<SugarMeasurementDTO> saveSugarMeasurement(@RequestBody SugarMeasurementDTO measurementDTO) {
        measurementDTOList.add(measurementDTO);
        return measurementDTOList;
    }

    @GetMapping(path = "/sugar/measurement")
    public List<SugarMeasurementDTO> getSugarMeasurements() {
        return measurementDTOList;
    }

    @DeleteMapping(path = "/sugar/measurement")
    public SugarMeasurementDTO deleteMeasurement(@RequestBody IndexMeasurementDTO indexDTO) {
        return measurementDTOList.remove(indexDTO.index.intValue());
    }
}
