package com.bankers.springboot.customerManagement.service;

import com.bankers.springboot.customerManagement.entity.Customer;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CustomerService {

    List<Customer> findAll();
    Customer findById(int theId);

    Customer save(Customer theCus);

    public void deleteById(int theId);
}
