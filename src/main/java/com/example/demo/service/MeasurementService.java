package com.example.demo.service;

import com.example.demo.controller.dto.SugarMeasurementDTO;
import com.example.demo.repository.MeasurementRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MeasurementService {
    private MeasurementRepository measurementRepository;

    public MeasurementService(MeasurementRepository measurementRepository) {
        this.measurementRepository = measurementRepository;
    }

    public void saveSugarMeasurement(SugarMeasurementDTO measurementDTO) {
        measurementRepository.save(measurementDTO);
    }


    public List<SugarMeasurementDTO> getSugarMeasurements() {
        return measurementRepository.getAll();
    }


    public void deleteMeasurement(Integer id) {
        measurementRepository.delete(id);
    }
}
