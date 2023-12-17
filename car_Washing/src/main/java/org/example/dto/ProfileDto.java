package org.example.dto;

import lombok.Getter;
import lombok.Setter;
import org.example.status.Status;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;

@Setter
@Configuration
@Getter
public class ProfileDto {
    private Integer id;
    private String name;
    private String surname;
    private String phone;
    private LocalDate localDate;
    private  Status status;
    private Status type;
    private String paw;



    @Override
    public String toString() {
        return "ProfileDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", phone='" + phone + '\'' +
                ", localDate=" + localDate +
                ", status=" + status +
                '}';
    }
}
