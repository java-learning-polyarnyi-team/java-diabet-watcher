package com.example.demo.repository;

import com.example.demo.controller.dto.SugarMeasurementDTO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SugarMeasurementRowMapper implements RowMapper<SugarMeasurementDTO> {

    @Override
    public SugarMeasurementDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
//        Integer id = rs.getInt("id");
//        float measurement = rs.getFloat("measurement");
//        return new SugarMeasurementDTO(id, measurement);

        return new SugarMeasurementDTO(
                rs.getInt("id"),
                rs.getFloat("measurement")
        );
    }
}
