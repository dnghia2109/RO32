package com.example.demomysql.repository;

import com.example.demomysql.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    Employee findByName(String name);

    List<Employee> findByTitle(String title);

    List<Employee> findEmployeeByAgeBetween(int age1, int age2);

    Employee findEmployeeByNameContainingIgnoreCase(String name);
}
