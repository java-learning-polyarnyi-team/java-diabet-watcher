package com.example.demo;

import com.example.demo.dto.NameDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
    public NameDTO nameDTO = new NameDTO();

    @GetMapping(path = "/hello")
    public String helloWorld() {
        return "hello world, " + nameDTO.name1;
    }

    @PostMapping(path = "/name")
    public NameDTO saveName(@RequestBody NameDTO name) {
        this.nameDTO = name;
        return this.nameDTO;
    }
}
