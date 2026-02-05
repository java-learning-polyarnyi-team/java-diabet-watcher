package com.example.demo.controller.dto;

public class SugarMeasurementDTO {
    private Integer id;
    private float measurement;

    public SugarMeasurementDTO (Integer id, float measurement) {
        this.measurement = measurement;
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public float getMeasurement() {
        return measurement;
    }
}
