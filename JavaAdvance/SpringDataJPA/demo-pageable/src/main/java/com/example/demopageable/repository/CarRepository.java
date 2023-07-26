package com.example.demopageable.repository;


import com.example.demopageable.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long> {
    List<Car> findAll();

    @Query("select c.year, count(c.id) from Car c where c.year = ?1")
    List<Car> countCarByYearmade(int year);

    @Query("select c.maker, count(c.id) from Car c group by c.maker")
    List<?> countCarByMaker();

}
