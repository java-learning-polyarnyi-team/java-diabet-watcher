package com.example.demo.service;

import com.example.demo.controller.dto.SugarMeasurementDTO;
import com.example.demo.repository.MeasurementRepository;
import org.springframework.stereotype.Service;

import java.util.List;


public class MeasurementService {
    private MeasurementRepository measurementRepository;

    public MeasurementService(MeasurementRepository measurementRepository) {
        this.measurementRepository = measurementRepository;
    }

    public List<SugarMeasurementDTO> saveSugarMeasurement(SugarMeasurementDTO measurementDTO) {
        return measurementRepository.save(measurementDTO);
    }


    public List<SugarMeasurementDTO> getSugarMeasurements() {
        return measurementRepository.getAll();
    }


    public SugarMeasurementDTO deleteMeasurement(Integer index) {
        return measurementRepository.delete(index);
    }
}
