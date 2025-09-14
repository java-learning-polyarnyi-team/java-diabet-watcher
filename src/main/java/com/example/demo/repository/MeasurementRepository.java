package com.example.demo.repository;

import com.example.demo.controller.dto.SugarMeasurementDTO;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MeasurementRepository {
    public List<SugarMeasurementDTO> measurementDTOList = new ArrayList<>();

    public List<SugarMeasurementDTO> save(SugarMeasurementDTO measurementDTO) {
        measurementDTOList.add(measurementDTO);
        return measurementDTOList;
    }

    public List<SugarMeasurementDTO> getAll() {
        return measurementDTOList;
    }

    public SugarMeasurementDTO delete(Integer index) {
        return measurementDTOList.remove(index.intValue());
    }
}
