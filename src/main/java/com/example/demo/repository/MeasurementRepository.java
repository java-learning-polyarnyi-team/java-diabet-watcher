package com.example.demo.repository;

import com.example.demo.controller.dto.SugarMeasurementDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Repository
public class MeasurementRepository {
    public List<SugarMeasurementDTO> measurementDTOList = new ArrayList<>();

    private SugarMeasurementRowMapper measurementRowMapper = new SugarMeasurementRowMapper();

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public MeasurementRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(SugarMeasurementDTO measurementDTO) {
        jdbcTemplate.update(
                "INSERT INTO sugar_measurement(measurement, user_id, created_at) VALUES (?, ?, ?)",
                measurementDTO.getMeasurement(), 1, LocalDateTime.now()
        );
    }

    public List<SugarMeasurementDTO> getAll() {
        return jdbcTemplate.query("SELECT * FROM sugar_measurement", measurementRowMapper);

    }

    public SugarMeasurementDTO getMeasurement(Integer id) {
        return jdbcTemplate.queryForObject("SELECT * FROM sugar_measurement WHERE id=?",
                measurementRowMapper, id);
    }

    public void delete(Integer id) {
        jdbcTemplate.update(
                "DELETE FROM sugar_measurement WHERE id=?",
                id
        );
    }
}
