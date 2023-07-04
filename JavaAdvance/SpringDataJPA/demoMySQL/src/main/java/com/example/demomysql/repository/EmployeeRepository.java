package com.example.demomysql.repository;

import com.example.demomysql.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    @Query("SELECT e FROM Employee e WHERE e.name=:name")
    Optional<Employee> findEmployeeByName(@Param("name") String name);

    @Query("SELECT e FROM Employee e WHERE e.age>?1 AND e.age<?2")
    List<Employee> findEmployeeByAgeBetween1(int age1, int age2);
    @Query("SELECT e FROM Employee e ORDER BY e.age ASC ")
    List<Employee> sortEmployeeByAge();
    @Query(value = "SELECT * FROM Employee WHERE title =?1",nativeQuery = true)
    List<Employee> findByTitleByNativeQuery(String title);


    // =================================================================================
    Employee findByName(String name);

    List<Employee> findByTitle(String title);

    List<Employee> findEmployeeByAgeBetween(int age1, int age2);

    List<Employee> findEmployeeByNameContainingIgnoreCase(String name);
}
