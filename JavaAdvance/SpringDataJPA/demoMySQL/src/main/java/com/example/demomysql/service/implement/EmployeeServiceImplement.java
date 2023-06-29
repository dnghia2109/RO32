package com.example.demomysql.service.implement;

import com.example.demomysql.Exception.DuplicateException;
import com.example.demomysql.entity.Employee;
import com.example.demomysql.repository.EmployeeRepository;
import com.example.demomysql.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImplement implements EmployeeService {


    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee saveEmployee(Employee employee) throws Exception {
        Employee employeeCheckExist = employeeRepository.findByName(employee.getName());
        if (employeeCheckExist != null) {
            throw new DuplicateException("Tên đã tồn tại trong hệ thống. Vui lòng sử dụng tên khác.");
        }
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> listAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(Integer id) {
        return employeeRepository.findById(id).orElse(null);
    }

    @Override
    public Employee updateEmployee(Integer id, Employee employee) {
        if (getEmployeeById(id) != null) {
            Employee curEmployee = getEmployeeById(id);
            curEmployee.setName(employee.getName());
            curEmployee.setAge(employee.getAge());
            curEmployee.setTitle(employee.getTitle());
            return employeeRepository.save(curEmployee);
        }
        return null;
    }

    @Override
    public Employee findEmployeeByName(String name) {
        return employeeRepository.findEmployeeByNameContainingIgnoreCase(name);
    }

    @Override
    public void deleteEmployee(Integer id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public List<Employee> findEmployeeByAgeBetween(int age1, int age2) {
        return employeeRepository.findEmployeeByAgeBetween(age1, age2);
    }
}
