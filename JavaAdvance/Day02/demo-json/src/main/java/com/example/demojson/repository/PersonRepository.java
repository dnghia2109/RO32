package com.example.demojson.repository;

import com.example.demojson.model.Car;
import com.example.demojson.model.Person;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

@Component
public class PersonRepository {
    private List<Person> personList = new ArrayList<>();
    public PersonRepository() {
        try {
            File file = ResourceUtils.getFile("classpath:static/person.json");
            ObjectMapper mapper = new ObjectMapper();
            personList.addAll(mapper.readValue(file, new TypeReference<List<Person>>(){}));
            personList.forEach(System.out::println);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Person> getAll() {
        return personList;
    }

//    public Map<String, Integer> getQuantityByJob() {
//        Map<Integer, String> map = new HashMap<Integer, String>();
//        for (Person person : personList) {
//            if (person.getJob().)
//        }
//        return null;
//    }


    public List<Person> getByGenderAndSortBySalary(String gender,String sorting) {
        List<Person> result = new ArrayList<>();
        for (Person person : personList) {
            if (person.getGender().equalsIgnoreCase(gender)) {
                result.add(person);
            }
        }

        if (sorting.equalsIgnoreCase("ASC")) {
            result.sort(new Comparator<Person>() {
                @Override
                public int compare(Person o1, Person o2) {
                    return o1.getSalary() - o2.getSalary();
                }
            });
        } else {
            result.sort(new Comparator<Person>() {
                @Override
                public int compare(Person o1, Person o2) {
                    return o2.getSalary() - o1.getSalary();
                }
            });
        }
        return result;
    }

    public Map<String, Integer> countPeopleByJob() {
        Map<String,Integer> results = new HashMap<>();
        for (Person person : personList) {
            if(results.get(person.getJob()) == null){
                results.put(person.getJob(),1);
            }else{
                results.put(person.getJob(), results.get(person.getJob())+1);
            }
        }
        return results;
    }

    public Map<String,Long> countPeopleByJob1(){

        return personList
                .stream()
                .collect(Collectors.groupingBy(Person::getJob, Collectors.counting()));
    }


    private List<Person> top5Person(String city){
        var cityPeoplesortBySalary = personList.stream().filter(person -> person.getCity().equals(city))
                .sorted(Comparator.comparing(Person::getSalary).reversed())
                .limit(5)
                .collect(Collectors.toList());
        return cityPeoplesortBySalary;
    }

    public Map<String,List<Person>> count5TopSalaryFromCity(){
        Map<String,List<Person>> results = new HashMap<>();

        for(Person person : personList){
            results.put(person.getCity(),this.top5Person(person.getCity()));
        }
        return results;
    }

    public List<Person> getPeopleOnJob(String job){
        return personList.stream().filter(person -> person.getJob().equals(job)).collect(Collectors.toList());
    }
}
