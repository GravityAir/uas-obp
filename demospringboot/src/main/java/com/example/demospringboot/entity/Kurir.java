package com.example.demospringboot.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "kurir")
public class Kurir extends User {

    @Column(name = "no_plat")
    private String noPlat;

    public Kurir() {}

    public Kurir(String nama, String password, String noPlat) {
        super(nama, password);
        this.noPlat = noPlat;
    }

    public void setNoPlat(String noPlat) {
        this.noPlat = noPlat;
    }

    public String getNoPlat() {
        return noPlat;
    }

    @Override
    public void Info() {
        System.out.println("Kurir Berhasil Didaftarkan");
    }
}