package com.example.demopageable.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    private String fullname;
    private String job;
    private String gender;
    private String city;
    private int salary;

    @Column(name="birthday")
    @Temporal(TemporalType.DATE)
    private Date birthday;

    @Column(name="sex")
    private Boolean sex;

    @Transient
    private int age;
    public int getAge(){
        Date safeDate = new Date(birthday.getTime());
        LocalDate birthDayInLocalDate = safeDate.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
        return Period.between(birthDayInLocalDate, LocalDate.now()).getYears();
    }

}
