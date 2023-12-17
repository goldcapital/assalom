package org.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
@Configuration
@ComponentScan(basePackages = "org.example")
public class ApplicationConfig {
  private   JdbcTemplate jdbcTemplate;
    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource);
        return jdbcTemplate;
    }
    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/spring_Book");
        dataSource.setUsername("task_spring");
        dataSource.setPassword("123456");
        return dataSource;
    }
    @Bean
    public void createTable(){
        String sql ="create table if not exists profile("+
                "id serial primary key,"+
                "namese varchar(25),"+
                "surname varchar(25),"+
                "phone varchar(25)," +
                "status varchar(25)," +
                "type varchar(30)" +
                "paw varchar(30)" +
                "localDate timestamp);" +

                "create table if not exists car(" +
                "id serial primary key," +
                "name varchar(30)," +
                "model varchar(30)," +
                "color varchar(30)," +
                "nubar varchar(30)," +
                "profile_id int  REFERENCES profile(id));"+


                "create table if not exists serviceType("+"id serial primary key," +
                "name varchar(30)," +
                "balance double precision " +
                "profile_Id int," +
                "employee_id int," +
                "localDate timestamp," +
                "  FOREIGN KEY (profile_Id) REFERENCES profile(id)," +
                "FOREIGN KEY (employee_id) REFERENCES profile(id))"

                +"create table if not exists card(" +"id serial primary key," +
                "name varchar," +
                "nubar varchar," +
                "balance double precision ," +
                "profile_phone REFERENCES profile(phone)," +
                "localDate timestamp  )";

        jdbcTemplate.execute(sql);
    }

}
