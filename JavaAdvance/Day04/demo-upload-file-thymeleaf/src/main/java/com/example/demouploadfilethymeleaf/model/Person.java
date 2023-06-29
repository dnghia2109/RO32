package com.example.demouploadfilethymeleaf.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.core.annotation.AliasFor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Person {
    private String name;
    private String nationality;
    private String birthdate;
    private String gender;
}
