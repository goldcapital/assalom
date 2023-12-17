package org.example;

import jdk.jfr.Name;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Configuration;

import javax.persistence.*;


@Entity
@Getter
@Setter
@Table(name = "emloyeejon")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Integer id;
  @Column(name = "firstName")
    private String firstName;
    @Column(name = "surname")
    private String surname;
    @Column(name = "phone")
    private String phone;
}
