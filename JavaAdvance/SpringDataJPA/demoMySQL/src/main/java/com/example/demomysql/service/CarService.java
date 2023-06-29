package com.example.demomysql.service;


import com.example.demomysql.entity.Car;

import java.util.List;


public interface CarService {
    //Lấy DS các car
    List<Car> getAll();

    //Lấy car theo id
    Car getCarById(Long id);

    //
    Car saveCar(Car car);

    //Cập nhật car
    Car updateCar(Long id, Car car);

    //Xóa car
    void deleteCar(Long id);
}
