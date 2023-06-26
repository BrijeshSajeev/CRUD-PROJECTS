package com.bankers.springboot.customerManagement.service;

import com.bankers.springboot.customerManagement.dao.CustomerRepo;
import com.bankers.springboot.customerManagement.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImp implements CustomerService{

    private CustomerRepo customerRepo;

    public CustomerServiceImp() {

    }

    @Autowired
    public CustomerServiceImp(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }

    @Override
    public List<Customer> findAll() {
        return customerRepo.findAll();
    }

    @Override
    public Customer findById(int theId) {

        Optional<Customer> result=customerRepo.findById(theId);
        Customer theCus=null;

        if(result.isPresent()){
            theCus=result.get();
        }
        else {
            throw new RuntimeException("Customer Id Not Found " +theId);
        }
        return theCus;
    }

    @Override
    public Customer save(Customer theCus) {
        Customer newCus=customerRepo.save(theCus);
        return newCus;
    }

    @Override
    public void deleteById(int theId) {
           customerRepo.deleteById(theId);
    }
}
