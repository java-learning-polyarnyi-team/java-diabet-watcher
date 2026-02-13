package com.example.demo.repository;

import com.example.demo.controller.dto.InjectionOfInsulinDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public class InjectionRepository {
    private JdbcTemplate jdbcTemplate;

    private InjectionRowMapper injectionRowMapper = new InjectionRowMapper();

    @Autowired
    public InjectionRepository (JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(InjectionOfInsulinDTO injectionDTO) {
        jdbcTemplate.update(
                "INSERT INTO insulin_injection(injection, user_id, created_at) VALUES (?, ?, ?)",
                injectionDTO.getInjetion(), 1, LocalDateTime.now()
        );
    }

    public List<InjectionOfInsulinDTO> getALL() {
        return jdbcTemplate.query("SELECT * FROM insulin_injection", injectionRowMapper);
    }

    public InjectionOfInsulinDTO getInjection(Integer id) {
        return jdbcTemplate.queryForObject("SELECT * FROM insulin_injection WHERE id=?",
                injectionRowMapper, id);
    }

    public void delete(Integer id) {
        jdbcTemplate.update("DELETE * FROM insulin_injection WHERE id=?", id);
    }
}
