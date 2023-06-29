package com.example.demomysql.controller;

import com.example.demomysql.entity.Car;
import com.example.demomysql.entity.Employee;
import com.example.demomysql.service.EmployeeService;
import com.example.demomysql.service.implement.EmployeeServiceImplement;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/employee")
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService; // cần có anntation @RequiredArgsConstructor khi dùng interface

//    @Autowired
//    private EmployeeServiceImplement employeeServiceImplement;

    @GetMapping("/get-all")
    public ResponseEntity<?> getAllemployee() {
         return ResponseEntity.ok().body(employeeService.listAll());
    }

    @PostMapping("/add-employee")
    public ResponseEntity<?> addNewEmployee(@RequestBody Employee employee) throws Exception {
        return ResponseEntity.ok().body(employeeService.saveEmployee(employee));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getEmpDeltail(@PathVariable Integer id) {
        return ResponseEntity.ok().body(employeeService.getEmployeeById(id));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateEmployee(@PathVariable Integer id, @RequestBody Employee employee) {
        return ResponseEntity.ok().body(employeeService.updateEmployee(id, employee));
    }

    @GetMapping("/find")
    public ResponseEntity<?> findEmployeeByName(@RequestParam String name) {
        return  ResponseEntity.ok().body(employeeService.findEmployeeByName(name));
    }

    @GetMapping("/find-by-age")
    public ResponseEntity<?> findEmployeeAgeBetween(@RequestParam int age1, @RequestParam int age2) {
        return ResponseEntity.ok().body(employeeService.findEmployeeByAgeBetween(age1, age2));
    }


}
