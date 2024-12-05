package com.example.demospringboot.repository;

import com.example.demospringboot.entity.Kurir;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
// Interface
public interface KurirRepository extends JpaRepository<Kurir, Integer> {
        Kurir findByNama(String nama);
}

