package com.example.demo.service;

import com.example.demo.controller.dto.CarbohydratesDTO;
import org.springframework.stereotype.Component;

@Component
public class CalculationService {
    public CarbohydratesDTO carbDTO;

    public float getCalculationOfInjection() {
        float injectUnits = (carbDTO.getCarbohydrates() / 10) * 2;
        return injectUnits;
    }
}
