package com.example.demospringboot.repository;

import com.example.demospringboot.entity.Admin;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
// Interface
public interface AdminRepository extends JpaRepository<Admin, Integer> {
        Admin findByNama(String nama);
}
