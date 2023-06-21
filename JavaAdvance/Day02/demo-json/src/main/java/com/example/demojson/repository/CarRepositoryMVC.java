package com.example.demojson.repository;

import com.example.demojson.model.Car;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class CarRepositoryMVC {
    private List<Car> cars = new ArrayList<>();

    public CarRepositoryMVC() {
        try {
            File file = ResourceUtils.getFile("classpath:static/car.json");
            ObjectMapper mapper = new ObjectMapper();
            cars.addAll(mapper.readValue(file, new TypeReference<List<Car>>(){}));
            cars.forEach(System.out::println);
//            Random random = new Random();
//            for (Car car:cars) {
//                car.setId(random.nextInt(1000000));
//            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Car> getList() {
        return cars;
    }


    public Car saveCar(Car car){
        int id;
        if (cars.isEmpty()) {
            id = 1;
        } else {
            Car lastCar = cars.get(cars.size() - 1);
            id = lastCar.getId() + 1;
        }
        car.setId(id);
        cars.add(car);
        return car;
    }

    public Car updateCar(Integer id,Car newcar){
        Car car = cars.stream().filter(car1 -> car1.getId() == id).findFirst().orElse(null);
        if(car != null){
            car.setModel(newcar.getModel());
            car.setMaker(newcar.getMaker());
            car.setYearmade(newcar.getYearmade());
            cars.set(cars.indexOf(car),car);
        }
        return car;
    }

    public void deleteCar(Integer id) {
        Car car = cars.stream().filter(car1 -> car1.getId() == id).findFirst().orElse(null);
        if(car != null){
            cars.remove(car);
        }
    }


    public List<Car> findByYear(Integer year) {
       List<Car> result = cars.stream().filter(car -> car.getYearmade() == year.intValue()).collect(Collectors.toList());
//        List<Car> result = new ArrayList<>();
//        for (Car car: cars) {
//            if (car.getYearmade() == year.intValue()) {
//                result.add(car);
//            }
//        }
        result.forEach(System.out::println);
        return result;
    }

    public List<Car> findByMaker(String maker) {
        List<Car> result = cars.stream().filter(car -> car.getMaker().equalsIgnoreCase(maker)).collect(Collectors.toList());
        return result;
    }

    public List<Car> sortBy(String sorted) {

        return null;
    }
}
