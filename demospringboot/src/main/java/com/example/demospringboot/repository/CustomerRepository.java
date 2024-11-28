package com.example.demospringboot.repository;

import com.example.demospringboot.entity.Customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
// Interface
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    Customer findByEmail(String email);  
}
