package com.example.demospringboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demospringboot.entity.Customer;
import com.example.demospringboot.repository.CustomerRepository;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> getAllUsers() {
        return customerRepository.findAll();
    }

    public Customer getUserById(int id) {
        return customerRepository.findById(id).orElse(null);
    }

    public Customer addUser(Customer cust) {
        return customerRepository.save(cust);
    }

    public Customer updateUser(int id, Customer cust) {
        cust.setUserId(id);
        return customerRepository.save(cust);
    }

    public void deleteUser(int id) {
        customerRepository.deleteById(id);
    }

    public Customer login(String email, String password) {
        Customer customer = customerRepository.findByEmail(email);
        if (customer != null && customer.getPassword().equals(password)) {
            return customer;
        }
        return null;
    }
}