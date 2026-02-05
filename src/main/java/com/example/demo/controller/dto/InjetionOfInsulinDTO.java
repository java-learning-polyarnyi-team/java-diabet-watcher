package com.example.demo.controller.dto;

public class InjetionOfInsulinDTO {
    private Integer id;
    private float injetion;

    public InjetionOfInsulinDTO (Integer id, float injection) {
        this.id = id;
        this.injetion = injection;
    }

    public Integer getId() {
        return id;
    }

    public float getInjetion() {
        return injetion;
    }
}
