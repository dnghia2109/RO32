package com.example.demoh2.service.implement;

import com.example.demoh2.entity.Car;
import com.example.demoh2.repository.CarRepository;
import com.example.demoh2.service.CarService;
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
