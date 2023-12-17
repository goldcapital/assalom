package org.example.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
@Getter
@Setter
@ToString
@Configuration
public class CarDto {
    private Integer id;
    private String name;
    private  String model;
    private String color;
    private  String nubar;
    private Integer profile_id;
    private LocalDate localDate;
}
