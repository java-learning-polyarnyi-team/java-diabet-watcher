package com.example.demo.controller;

import com.example.demo.controller.dto.InjectionOfInsulinDTO;
import com.example.demo.service.InjectionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class InjectionController {
    public InjectionService injectionService;

    public InjectionController(InjectionService injectionService) {
        this.injectionService = injectionService;
    }

    @PostMapping (path = "/insulin/injection")
    public void saveInsulinInjection(@RequestBody InjectionOfInsulinDTO injectionDTO) {
        injectionService.saveInsulinInjection(injectionDTO);
    }

    @GetMapping (path = "/insulin/injection")
    public List<InjectionOfInsulinDTO> getInsulinInjection() {
        return injectionService.getInsulinInjection();
    }

    @DeleteMapping (path = "/insulin/injection/{id}")
    public void deleteInsulinInjection(@PathVariable("id") Integer id) {
        injectionService.deleteInsulinInjection(id);
    }
}
