package com.example.demo.controller;

import com.example.demo.controller.dto.NutritionFactsDTO;
import com.example.demo.service.NutritionFactsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class NutritionFactsController {
    public NutritionFactsService nutritionService;

    public NutritionFactsController(NutritionFactsService nutritionService) {
        this.nutritionService = nutritionService;
    }

    @PostMapping (path = "/nutrition/facts")
    public void saveNutritionFacts(@RequestBody NutritionFactsDTO nutritionFactsDTO) {
        nutritionService.saveNutritionFacts(nutritionFactsDTO);
    }

    @GetMapping (path = "/nutrition/facts")
    public List<NutritionFactsDTO> getAllNutritionFacts() {
        return nutritionService.getAllNutritionFacts();
    }

    @DeleteMapping (path = "/nutrition/facts/{id}")
    public void deleteNutritionFacts(@PathVariable("id") Integer id) {
        nutritionService.deleteNutritionFacts(id);
    }
}
