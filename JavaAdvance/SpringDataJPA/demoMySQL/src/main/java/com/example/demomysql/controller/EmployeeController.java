package com.example.demomysql.controller;

import com.example.demomysql.entity.Employee;
import com.example.demomysql.service.IEmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/employee")
@RequiredArgsConstructor
@CrossOrigin("*")
public class EmployeeController {
    private final IEmployeeService IEmployeeService; // cần có anntation @RequiredArgsConstructor khi dùng interface

//    @Autowired
//    private EmployeeServiceImplement employeeServiceImplement;

    @GetMapping("/get-all")
    public ResponseEntity<?> getAllemployee() {
         return ResponseEntity.ok().body(IEmployeeService.listAll());
    }

    @PostMapping("/add-employee")
    public ResponseEntity<?> addNewEmployee(@RequestBody Employee employee) throws Exception {
        return ResponseEntity.ok().body(IEmployeeService.saveEmployee(employee));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getEmpDeltail(@PathVariable Integer id) {
        return ResponseEntity.ok().body(IEmployeeService.getEmployeeById(id));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateEmployee(@PathVariable Integer id, @RequestBody Employee employee) {
        return ResponseEntity.ok().body(IEmployeeService.updateEmployee(id, employee));
    }

    @GetMapping("/find")
    public ResponseEntity<?> findEmployeeByName(@RequestParam String name) {
        return  ResponseEntity.ok().body(IEmployeeService.findEmployeeByName(name));
    }

    @GetMapping("/find-by-age")
    public ResponseEntity<?> findEmployeeAgeBetween(@RequestParam int age1, @RequestParam int age2) {
        return ResponseEntity.ok().body(IEmployeeService.findEmployeeByAgeBetween(age1, age2));
    }

    @GetMapping("/sort-by-age")
    public ResponseEntity<?> sortEmployeeByAge() {
        return ResponseEntity.ok().body(IEmployeeService.getEmployeeSortByAge());
    }



}
