package org.example.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
@Getter
@Setter
@ToString
@Configuration
public class CardDto {
    private Integer id;
    private String name;
    private  String nubar;
    private double balance;
    private String profile_phone;
    private LocalDate localDate;
}
