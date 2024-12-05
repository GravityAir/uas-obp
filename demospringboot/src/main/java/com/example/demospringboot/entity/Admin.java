package com.example.demospringboot.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "admin")
public class Admin extends User {

    public Admin() {}

    public Admin(String nama, String password) {
        super(nama, password);
    }

    @Override
    public void Info() {
        System.out.println("Admin Berhasil Ditambahkan");
    }
}