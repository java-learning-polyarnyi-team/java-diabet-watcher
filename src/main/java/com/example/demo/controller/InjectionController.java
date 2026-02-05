package com.example.demo.controller;

import com.example.demo.controller.dto.InjetionOfInsulinDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class InjectionController {

    @PostMapping (path = "/insulin/injection")
    public void saveInsulinInjection(@RequestBody InjetionOfInsulinDTO injectionDTO) {

    }

    @GetMapping (path = "/insulin/injection")
    public List<InjetionOfInsulinDTO> getInsulinInjection() {
        return null;
    }

    @DeleteMapping (path = "/insulin/injection/{id}")
    public void deleteInsulinInjection(@PathVariable("id") Integer id) {

    }
}
