package com.example.customerinfo.repository;

import com.example.customerinfo.mapper.CustomerMapper;
import com.example.customerinfo.model.Customer;
import com.example.customerinfo.model.CustomerPoJo;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class CustomerRepository {
    private List<Customer> customers = new ArrayList<>();

    public CustomerRepository() {
        customers.add(new Customer(1,"Nguyen Van A","nva@gmail.com", 101234L));
        customers.add(new Customer(2,"Lai Duy Nghia","ldn@gmail.com",156789L));
        customers.add(new Customer(3,"Nguyen Van B","nvb@gmail.com",101113L));
        customers.add(new Customer(4,"Nguyen Van C","nvc@gmail.com",101114L));
    }
    public List<Customer> getAll(){
        return customers;
    }
    public Customer findById(Integer id){
        return customers.stream().filter(c->c.getId()==id).findFirst().orElse(null);
    }

    public Customer findByEmail(String email){
        return customers.stream().filter(c->c.getEmail() == email).findFirst().orElse(null);
    }

    public Customer update(Integer id, CustomerPoJo pojo){
        Customer update_customer = CustomerMapper.INSTANCE.pojoToCustomer(pojo);
        update_customer.setId(id);
        customers= customers.stream().map(c->{
            if(c.getId()==id) return update_customer;
            else return c;
        }).collect(Collectors.toList());
        return update_customer;
    }
    public Customer save(CustomerPoJo pojo){
        Customer customer = CustomerMapper.INSTANCE.pojoToCustomer(pojo);
        Customer lastCustomer = customers.get(customers.size() - 1);
        var id = lastCustomer.getId() + 1;
        customer.setId(id);
        customers.add(customer);
        return customer;
    }
    public Customer create(Customer customer){
        int id;
        if (customers.isEmpty()) {
            id = 1;
        } else {
            Customer lastCustomer = customers.get(customers.size() - 1);
            id = lastCustomer.getId() + 1;
        }
        customer.setId(id);
        customers.add(customer);
        return customer;
    }
    public Customer delete(Integer id){
        Optional<Customer> customer = customers.stream().filter(c->c.getId()==id).findFirst();
        if(customer.isPresent()){
            customers.remove(customer.get());
            return customer.get();
        }
        return null;
    }

    public Customer findEmail(String email){
        return customers.stream().filter(c->c.getEmail().contains(email)).findAny().orElse(null);
    }

    public List<Customer> sort(String sort){
//        orderList.forEach(l-> System.out.println(l.getFullname()));
        if (sort.equalsIgnoreCase("ASC")) {
            return customers.stream().sorted(Comparator.comparing(Customer::getFullName)).collect(Collectors.toList());
        } else {
            return customers.stream().sorted(Comparator.comparing(Customer::getFullName).reversed()).collect(Collectors.toList());
        }
    }

}
