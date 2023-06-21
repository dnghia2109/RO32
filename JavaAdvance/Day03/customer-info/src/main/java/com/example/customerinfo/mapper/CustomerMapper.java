package com.example.customerinfo.mapper;

import com.example.customerinfo.model.Customer;
import com.example.customerinfo.model.CustomerPoJo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CustomerMapper {
    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);
    CustomerPoJo customerToPojo(Customer customer);
    Customer pojoToCustomer(CustomerPoJo poJo);
}
