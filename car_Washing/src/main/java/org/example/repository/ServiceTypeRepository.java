package org.example.repository;

import org.example.dto.ProfileDto;
import org.example.dto.ServiceTypeDTO;
import org.example.service.ServiceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class ServiceTypeRepository {
    @Autowired
   private JdbcTemplate jdbcTemplate;

        public void create(ServiceTypeDTO dto) {
            String sql = "insert into profile(name,bahosi,localDate) values('%s','%s','%s','%s','%s');";
            sql=String.format(sql,dto.getName(),dto.getBalance(), dto.getLocalDate());
            jdbcTemplate.update(sql);
        }




        public ServiceTypeDTO getById(Integer id) {
            return null;
        }

        public List<ServiceTypeDTO> all() {
            String sql = "select * from profile";
            List<ServiceTypeDTO>list =jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(ServiceTypeDTO.class));
            return list;
            
        }

        public List<ServiceTypeDTO> getAllActive() {
            return null;
        }

        public void changeStatus(Integer id, ServiceTypeService status) {
            return;
        }
    public void createTable() {
        String sql ="create table if not exists ServiceTypeDTO("+
                "id serial primary key,"+
                "name varchar(25),"+
                "bahosi varchar(25),"+
                "localDate timestamp);";
        jdbcTemplate.execute(sql);
    }
    }


