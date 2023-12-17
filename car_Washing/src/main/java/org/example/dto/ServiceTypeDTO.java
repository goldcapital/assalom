package org.example.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
@Setter
@Getter
@ToString
@Configuration
public class ServiceTypeDTO {
    private Integer id;
    private  String name;
    private double balance;
    private Integer profile_Id;
    private Integer employee_id;
    private LocalDate localDate;
}
