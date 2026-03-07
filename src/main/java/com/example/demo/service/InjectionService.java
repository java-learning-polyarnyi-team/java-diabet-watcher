package com.example.demo.service;

import com.example.demo.controller.dto.InjectionOfInsulinDTO;
import com.example.demo.repository.InjectionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InjectionService {
    private InjectionRepository injectionRepository;

    public InjectionService(InjectionRepository injectionRepository) {
        this.injectionRepository = injectionRepository;
    }

    public void saveInsulinInjection(InjectionOfInsulinDTO injectionDTO) {
        injectionRepository.save(injectionDTO);
    }

    public List<InjectionOfInsulinDTO> getInsulinInjection() {
        return injectionRepository.getALL();
    }

    public void deleteInsulinInjection(Integer id) {
        injectionRepository.delete(id);
    }
}
