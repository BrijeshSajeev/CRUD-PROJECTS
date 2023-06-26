package com.bankers.springboot.customerManagement.dao;

import com.bankers.springboot.customerManagement.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<Customer,Integer> {
}
