package com.example.demo.controller;

import com.example.demo.service.CalculationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculationController {
    public CalculationService calculationService;

    public CalculationController(CalculationService calculationService) {
        this.calculationService = calculationService;
    }

    @GetMapping(path = "/calculation/injection")
    public float getCalculationOfInjection() {
        return calculationService.getCalculationOfInjection();
    }
}
