package com.example.demomysql.controller;

import com.example.demomysql.entity.Car;
import com.example.demomysql.service.CarService;
import com.example.demomysql.service.implement.CarServiceImplement;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/")
@RequiredArgsConstructor
public class CarController {

//    @Autowired
//    private CarServiceImplement carServiceImplement;
    private final CarService carService;

    @GetMapping("/")
    public ResponseEntity<?> getAllCar() {
        return ResponseEntity.ok().body(carService.getAll());
    }

    @PostMapping("/save")
    public ResponseEntity<?> saveCar(@RequestBody Car car) {
        return ResponseEntity.ok().body(carService.saveCar(car));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateCar(@PathVariable Long id, @RequestBody Car car) {
        return ResponseEntity.ok().body(carService.updateCar(id, car));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCar(@PathVariable Long id) {
        carService.deleteCar(id);
        return ResponseEntity.ok("Xóa thành công");
    }

}
