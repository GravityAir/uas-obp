package com.example.demospringboot.repository;

import com.example.demospringboot.entity.Pengiriman;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
// Interface
public interface PengirimanRepository
    extends JpaRepository<Pengiriman, Integer> {
}