package com.example.demo.controller.dto;

public class InsulinCalculationDTO {
    private float injectUnits;

    public InsulinCalculationDTO(float injectUnits) {
        this.injectUnits = injectUnits;
    }

    public float getInjectUnits() {
        return injectUnits;
    }

    public void setInjectUnits(float injectUnits) {
        this.injectUnits = injectUnits;
    }
}
