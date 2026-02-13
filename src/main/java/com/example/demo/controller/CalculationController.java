package com.example.demo.controller;

import com.example.demo.controller.dto.CarbohydratesDTO;
import com.example.demo.controller.dto.InsulinCalculationDTO;
import com.example.demo.service.CalculationService;
import org.springframework.web.bind.annotation.*;

@RestController
public class CalculationController {
    public CalculationService calculationService;

    public CalculationController(CalculationService calculationService) {
        this.calculationService = calculationService;
    }

    @PostMapping(path = "/calculation/injection")
    public float calculationOfInjection(@RequestBody CarbohydratesDTO carbDTO) {
        return calculationService.getCalculationOfInjection(carbDTO);
    }

    @PostMapping (path = "/insulin/sugar/{sugarId}/nutriton/{nutritionId}/calculation")
    public InsulinCalculationDTO insulinCalculation(@PathVariable Integer sugarId, @PathVariable Integer nutritionId) {
        return calculationService.insulinCalculation(sugarId, nutritionId);
    }
}
