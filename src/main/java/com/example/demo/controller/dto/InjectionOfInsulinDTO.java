package com.example.demo.controller.dto;

public class InjectionOfInsulinDTO {
    private Integer id;
    private float injetion;

    public InjectionOfInsulinDTO(Integer id, float injection) {
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
