package org.example.repository;

import org.example.dto.ProfileDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProfileRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public void create(ProfileDto dto) {
        String sql = "insert into profile(name,surname,type,phone,status,localDate) values('%s','%s','%s','%s','%s','%s','%s');";
        sql=String.format(sql,dto.getName(),dto.getSurname(),dto.getType(),dto.getPhone(),dto.getStatus(), dto.getLocalDate(),dto.getPaw());
        jdbcTemplate.update(sql);
    }



    public void update(Integer id, ProfileDto dto) {
        String str = "UPDATE  profile set name='%s',surname='%s' where id="+id;
        str=String.format(str,dto.getName(),dto.getSurname());
        jdbcTemplate.update(str);

    }

   /* public List<ProfileDto> getById(Integer id) {
        String sql = "select * from profile WHERE id="+id;
        List< ProfileDto>list =  jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(ProfileDto.class));



       return null;
    }*/

    public List<ProfileDto> profileList() {
        String sql = "select * from profile";
       List< ProfileDto>list =jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(ProfileDto.class));
        return list;


    }


}
