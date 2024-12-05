package com.example.demospringboot.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "user")
public abstract class User {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;

    @Column(name = "nama")
	private String nama;

	@Column(name = "password")
	private String password;

	public User() {}

    public User(String nama, String password) {
        this.nama = nama;
        this.password = password;
    }

    public void setUserId(int id) {
        this.userId = id;
    }
    public int getUserid() {
        return userId;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }
    public String getNama() {
        return nama;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getPassword() {
        return password;
    }

    public abstract void Info();
}
