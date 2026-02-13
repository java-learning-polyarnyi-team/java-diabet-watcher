package com.example.demo.controller.dto;

import java.sql.Timestamp;

public class NutritionFactsDTO {
    private Integer id;
    private Integer fat;
    private Integer carb;
    private Integer protein;
    private Timestamp createdAt;

    public NutritionFactsDTO(Integer id, Integer fat, Integer carb, Integer protein, Timestamp createdAt) {
        this.id = id;
        this.fat = fat;
        this.carb = carb;
        this.protein = protein;
        this.createdAt = createdAt;
    }

    public Integer getId() {
        return id;
    }

    public Integer getFat() {
        return fat;
    }

    public Integer getCarb() {
        return carb;
    }

    public Integer getProtein() {
        return protein;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }
}
