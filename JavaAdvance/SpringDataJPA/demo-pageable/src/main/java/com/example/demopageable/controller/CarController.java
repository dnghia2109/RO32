package com.example.demopageable.controller;

import com.example.demopageable.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/car")
public class CarController {


    @Autowired
    private CarRepository carRepository;

    @GetMapping("/count-car-by-maker")
    public ResponseEntity<?> countCarByMaker() {
        return ResponseEntity.ok().body(carRepository.countCarByMaker());
    }
}
