package com.example.demopageable;


import com.example.demopageable.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long> {
    List<Car> findAll();

    @Query("")
    List<Car> countCarByYearmade(int year);
}
