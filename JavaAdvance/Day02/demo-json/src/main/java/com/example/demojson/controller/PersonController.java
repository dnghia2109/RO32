package com.example.demojson.controller;

import com.example.demojson.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/person/")
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    @GetMapping("/")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(personRepository.getAll());
    }

    @GetMapping("/filter")
    public ResponseEntity<?> filterByGenderAndSalarySorting(@RequestParam("gender")String gender, @RequestParam("sorting")String sorting){
        return new ResponseEntity<>(personRepository.getByGenderAndSortBySalary(gender, sorting),HttpStatus.OK);
    }
//    @GetMapping("/{job}")
//    public ResponseEntity<?> filterOnJob(@PathVariable String job){
//        return new ResponseEntity<>(personRepository.getPeopleOnJob(job), HttpStatus.OK);
//    }

    @GetMapping("/jobCount")
    public ResponseEntity<?> coutingJob(){
        return new ResponseEntity<>(personRepository.countPeopleByJob(),HttpStatus.OK);
    }

    @GetMapping("/citySalary")
    public ResponseEntity<?> topCitySalary(){
        return new ResponseEntity<>(personRepository.count5TopSalaryFromCity(),HttpStatus.OK);
    }

}
