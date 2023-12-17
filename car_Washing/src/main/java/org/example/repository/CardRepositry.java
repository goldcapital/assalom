package org.example.repository;

import org.example.dto.CardDto;
import org.example.dto.ProfileDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

@Configuration
public class CardRepositry {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public List<CardDto> all() {
        String sql = "select * from card";
        List<CardDto>list =jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(CardDto.class));
        return list;
    }
}
