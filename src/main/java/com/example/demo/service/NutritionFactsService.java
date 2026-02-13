package com.example.demo.service;

import com.example.demo.controller.dto.NutritionFactsDTO;
import com.example.demo.repository.NutritionFactsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NutritionFactsService {
    private NutritionFactsRepository nutritionRepository;

    public NutritionFactsService(NutritionFactsRepository nutritionRepository) {
        this.nutritionRepository = nutritionRepository;
    }

    public void saveNutritionFacts(NutritionFactsDTO nutritionFactsDTO) {
        nutritionRepository.save(nutritionFactsDTO);
    }

    public List<NutritionFactsDTO> getAllNutritionFacts() {
        return nutritionRepository.getAll();
    }

    public void deleteNutritionFacts(Integer id) {
        nutritionRepository.delete(id);
    }
}
