package com.example.demojson.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Car {

    private Integer id, yearmade;
    private String model, maker;

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", yearmade=" + yearmade +
                ", model='" + model + '\'' +
                ", maker='" + maker + '\'' +
                '}';
    }
}