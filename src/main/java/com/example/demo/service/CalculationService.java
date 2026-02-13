package com.example.demo.service;

import com.example.demo.controller.dto.CarbohydratesDTO;
import com.example.demo.controller.dto.InsulinCalculationDTO;
import com.example.demo.controller.dto.NutritionFactsDTO;
import com.example.demo.controller.dto.SugarMeasurementDTO;
import com.example.demo.repository.MeasurementRepository;
import com.example.demo.repository.NutritionFactsRepository;
import org.springframework.stereotype.Service;

@Service
public class CalculationService {
    final float BREAD_UNIT = 10; //10 грамм углеводов это 1 хлебная единица (ХЕ),
    // используется для расчета количества ХЕ в приеме пищи
    final int INJECTION_PER_BREAD_UNIT = 2; //2 единицы инсулина на 1 хлебную единицу

    private MeasurementRepository measurementRepository;
    private NutritionFactsRepository nutritionRepository;

    public CalculationService(MeasurementRepository measurementRepository, NutritionFactsRepository nutritionRepository) {
        this.measurementRepository = measurementRepository;
        this.nutritionRepository = nutritionRepository;
    }

    public float getCalculationOfInjection(CarbohydratesDTO carbDTO) {
        float injectUnits = (carbDTO.getCarbohydrates() / BREAD_UNIT) * INJECTION_PER_BREAD_UNIT;
        return injectUnits;
    }


    public InsulinCalculationDTO insulinCalculation(Integer sugarId, Integer nutritionId) {
        SugarMeasurementDTO measurement = measurementRepository.getMeasurement(sugarId);
        NutritionFactsDTO nutritionFacts = nutritionRepository.getNutritionFacts(nutritionId);
        float injectUnits = (nutritionFacts.getCarb() / BREAD_UNIT) * INJECTION_PER_BREAD_UNIT;
        return new InsulinCalculationDTO(injectUnits);
    }
}
