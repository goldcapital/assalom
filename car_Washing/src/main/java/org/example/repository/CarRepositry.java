package org.example.repository;

import org.example.dto.CarDto;
import org.example.dto.CardDto;
import org.example.dto.ProfileDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CarRepositry{


  @Autowired
      private   JdbcTemplate jdbcTemplate;


        public void create(CarDto dto) {
            String sql = "insert into car(name,modeli,rangi,nubar,localDate) values('%s','%s','%s','%s','%s');";
            sql=String.format(sql,dto.getName(),dto.getModel(),dto.getColor(),dto.getNubar(),dto.getLocalDate());
            jdbcTemplate.update(sql);


        }

        public CardDto findByCarNumber(String carNumber) {
            String sql = "select * from car WHERE nubar="+carNumber;
            CardDto list = (CardDto) jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(CardDto.class));

            return list;

        }

        public CarDto findById(Integer id) {
            String sql = "select * from car WHERE id="+id;
            CarDto list = (CarDto) jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(CarDto.class));

            return list;
        }

        public List<CarDto> all() {
            String sql = "select * from car";
            List< CarDto>list =  jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(CarDto.class));
            return list;


    }

}
