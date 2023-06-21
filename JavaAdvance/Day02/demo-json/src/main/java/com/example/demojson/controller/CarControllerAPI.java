package com.example.demojson.controller;

import com.example.demojson.model.Car;
import com.example.demojson.repository.CarRepositoryMVC;
import com.example.demojson.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/car")
public class CarControllerAPI {

    @Autowired
    private CarRepositoryMVC carRepositoryMVC;
    @Autowired
    private CarService carService;


    @GetMapping("/")
    public ResponseEntity<List<Car>> getAll() {
        return ResponseEntity.ok(carRepositoryMVC.getList());
    }

    @PostMapping("/add-car")
    public ResponseEntity<?> createNewCar(@RequestBody Car car) {
        Car newCar = carRepositoryMVC.saveCar(car);

        return ResponseEntity.ok(newCar);
    }

    @PutMapping("/update-car/{id}")
    public ResponseEntity<?> updateCar(@PathVariable Integer id, @RequestBody Car car) {
        return ResponseEntity.ok(carRepositoryMVC.updateCar(id, car));
    }

    @DeleteMapping("/delete-car/{id}")
    public ResponseEntity<?> deleteCar(@PathVariable Integer id) {
        return ResponseEntity.ok("Xóa thành công");
    }

    @GetMapping("/car-by-year/{year}")
    public List<Car> getByYear(@PathVariable("year") Integer year){
        return carRepositoryMVC.findByYear(year);
    }

    @GetMapping("/car-by-maker/maker")
    public ResponseEntity<?> getByMaker(@RequestParam("maker") String maker){
        return new ResponseEntity<>(carRepositoryMVC.findByMaker(maker), HttpStatus.OK);
    }

    @GetMapping("/sorting")
    public ResponseEntity<?> sortByYear(@RequestParam("sorted") String sorted){
        return new ResponseEntity<>(carRepositoryMVC.sortBy(sorted),HttpStatus.OK);
    }
}
