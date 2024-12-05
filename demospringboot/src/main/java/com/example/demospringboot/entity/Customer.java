package com.example.demospringboot.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer extends User {

    @Column(name = "email")
    private String email;

    public Customer() {}

    public Customer(String nama, String password, String email) {
        super(nama, password);
        this.email = email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getEmail() {
        return email;
    }

    @Override
    public void Info() {
        System.out.println("Customer Berhasil Didaftarkan");
    }
}