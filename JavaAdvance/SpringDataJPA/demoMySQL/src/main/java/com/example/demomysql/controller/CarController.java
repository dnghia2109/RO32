package com.example.demomysql.controller;

import com.example.demomysql.entity.Car;
import com.example.demomysql.service.ICarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/")
@RequiredArgsConstructor
public class CarController {

//    @Autowired
//    private CarServiceImplement carServiceImplement;
    private final ICarService ICarService;

    @GetMapping("/")
    public ResponseEntity<?> getAllCar() {
        return ResponseEntity.ok().body(ICarService.getAll());
    }

    @PostMapping("/save")
    public ResponseEntity<?> saveCar(@RequestBody Car car) {
        return ResponseEntity.ok().body(ICarService.saveCar(car));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateCar(@PathVariable Long id, @RequestBody Car car) {
        return ResponseEntity.ok().body(ICarService.updateCar(id, car));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCar(@PathVariable Long id) {
        ICarService.deleteCar(id);
        return ResponseEntity.ok("Xóa thành công");
    }

}
