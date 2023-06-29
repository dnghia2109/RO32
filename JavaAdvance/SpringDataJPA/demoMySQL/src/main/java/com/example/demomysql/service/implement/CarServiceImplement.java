package com.example.demomysql.service.implement;

import com.example.demomysql.Exception.NotFoundException;
import com.example.demomysql.entity.Car;
import com.example.demomysql.repository.CarRepository;
import com.example.demomysql.service.CarService;
import com.example.demomysql.repository.CarRepository;
import com.example.demomysql.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImplement implements CarService {


    @Autowired
    private CarRepository carRepository;

    @Override
    public List<Car> getAll() {
        return carRepository.findAll();
    }

    @Override
    public Car getCarById(Long id) {
        if (carRepository.findById(id).isEmpty()) {
            throw new NotFoundException("Sản phẩm không tồn tại");
        }

        return carRepository.findById(id).orElse(null); // or else sẽ trả về Car nếu có và null nếu ko có
    }

    @Override
    public Car saveCar(Car car) {
        return carRepository.save(car);
    }

    @Override
    public Car updateCar(Long id, Car car) {
        if (getCarById(id) != null) {
            Car carExist = getCarById(id);
            carExist.setModel(car.getModel());
            carExist.setMaker(car.getMaker());
            carExist.setYearMade(car.getYearMade());
            return carRepository.save(carExist);
        }
        return null;
    }

    @Override
    public void deleteCar(Long id) {
        carRepository.deleteById(id);
    }
}
