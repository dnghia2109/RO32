package com.example.demomysql.service;

import com.example.demomysql.entity.Employee;

import java.util.List;

public interface EmployeeService {
    Employee saveEmployee(Employee employee) throws Exception;
    List<Employee> listAll();
    Employee getEmployeeById(Integer id);
    Employee updateEmployee(Integer id,Employee employee);

    Employee findEmployeeByName(String name);

    void deleteEmployee(Integer id);

    List<Employee> findEmployeeByAgeBetween(int age1, int age2);
}
