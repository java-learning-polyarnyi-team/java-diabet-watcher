package com.example.demo.repository;

import com.example.demo.controller.dto.NutritionFactsDTO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class NutritionFactsRowMapper implements RowMapper<NutritionFactsDTO> {

    @Override
    public NutritionFactsDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new NutritionFactsDTO(
                rs.getInt("id"),
                rs.getInt("fat"),
                rs.getInt("carb"),
                rs.getInt("protein"),
                rs.getTimestamp("created_at")
        );
    }
}
