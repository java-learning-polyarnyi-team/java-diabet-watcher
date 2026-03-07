package com.example.demo.repository;

import com.example.demo.controller.dto.NutritionFactsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public class NutritionFactsRepository {
    private JdbcTemplate jdbcTemplate;

    private NutritionFactsRowMapper nutritionRowMapper = new NutritionFactsRowMapper();

    @Autowired
    public NutritionFactsRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(NutritionFactsDTO nutritionDTO) {
        jdbcTemplate.update(
                "INSERT INTO nutrition_facts(fat, carb, protein, user_id, created_at) VALUES(?, ?, ?, ?, ?)",
                nutritionDTO.getFat(), nutritionDTO.getCarb(), nutritionDTO.getProtein(), 1, LocalDateTime.now()
        );
    }

    public List<NutritionFactsDTO> getAll() {
        return jdbcTemplate.query("SELECT * FROM nutrition_facts", nutritionRowMapper);
    }

    public NutritionFactsDTO getNutritionFacts(Integer id) {
        return jdbcTemplate.queryForObject("SELECT * FROM nutrition_facts WHERE id=?",
                nutritionRowMapper, id);
    }

    public void delete(Integer id) {
        jdbcTemplate.update("DELETE FROM nutrition_facts WHERE id=?", id);
    }
}
