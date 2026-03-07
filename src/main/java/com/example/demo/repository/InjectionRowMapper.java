package com.example.demo.repository;

import com.example.demo.controller.dto.InjectionOfInsulinDTO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class InjectionRowMapper implements RowMapper<InjectionOfInsulinDTO> {

    @Override
    public InjectionOfInsulinDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new InjectionOfInsulinDTO(
                rs.getInt("id"),
                rs.getFloat("injection")
        );
    }
}
