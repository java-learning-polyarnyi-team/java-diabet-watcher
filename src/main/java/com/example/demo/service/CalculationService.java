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
    final float MIN_SUGAR = 5;
    final float MAX_SUGAR = 7.5f;

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
        float injectUnits = (nutritionFacts.getCarb() / BREAD_UNIT) * INJECTION_PER_BREAD_UNIT + sugarCorrection(measurement);
        return new InsulinCalculationDTO(injectUnits);
    }

    public Integer sugarCorrection(SugarMeasurementDTO sugarMeasurement) {
        Integer correction = 0; //количество доп. инсулина для корректировки сахара в зависимости от его уровня
        if (sugarMeasurement.getMeasurement() > MAX_SUGAR) {
            return correction + 1;
        }
        else if (sugarMeasurement.getMeasurement() < MIN_SUGAR) {
            return correction - 1;
        }
        else {
            return correction;
        }
    }
}

