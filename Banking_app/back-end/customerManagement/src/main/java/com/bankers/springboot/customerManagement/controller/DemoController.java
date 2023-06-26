package com.bankers.springboot.customerManagement.controller;

import com.bankers.springboot.customerManagement.entity.Customer;
import com.bankers.springboot.customerManagement.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class DemoController {

    private CustomerService customerService;

    @Autowired
    public DemoController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/customers")
    public List<Customer> listAll(){
        return customerService.findAll();
    }

    @GetMapping("/customers/{cusId}")
    public Customer findById(@PathVariable int cusId){
        return customerService.findById(cusId);
    }

    @PostMapping("/customers")
    public Customer save(@RequestBody Customer theCustomer){
        theCustomer.setId(0);
        Customer newCus= customerService.save(theCustomer);

        return newCus;
    }

    @PutMapping("/customers")
    public Customer update(@RequestBody Customer theCus){
        Customer newCus= customerService.save(theCus);
        return newCus;
    }

    @DeleteMapping("/customers/{cusId}")
    public int deleteCus(@PathVariable int cusId){
        customerService.deleteById(cusId);
        return cusId;
    }






}
