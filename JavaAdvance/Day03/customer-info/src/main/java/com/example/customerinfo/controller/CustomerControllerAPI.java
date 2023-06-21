package com.example.customerinfo.controller;

import com.example.customerinfo.model.CustomerPoJo;
import com.example.customerinfo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customer")
public class CustomerControllerAPI {

    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping("/")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(customerRepository.getAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getCustomerById(@PathVariable("id") Integer id){
        return ResponseEntity.ok().body(customerRepository.findById(id));
    }

    @PostMapping
    public ResponseEntity<?> addCustomer(@RequestBody CustomerPoJo pojo){
        return ResponseEntity.ok().body(customerRepository.save(pojo));
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<?> edit(@PathVariable("id") Integer id, @RequestBody CustomerPoJo pojo){
        return ResponseEntity.ok().body(customerRepository.update(id,pojo));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Integer id){
        return ResponseEntity.ok().body(customerRepository.delete(id));
    }

    @GetMapping("/sort-name")
    public ResponseEntity<?>  sortByName(@RequestParam String sort) {
        return ResponseEntity.ok().body(customerRepository.sort(sort));
    }
}
