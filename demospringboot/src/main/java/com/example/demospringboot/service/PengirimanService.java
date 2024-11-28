package com.example.demospringboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demospringboot.entity.Pengiriman;
import com.example.demospringboot.repository.PengirimanRepository;

import java.util.List;

@Service
public class PengirimanService {
    @Autowired
    private PengirimanRepository pengirimanRepository;

    public List<Pengiriman> getAllUsers() {
        return pengirimanRepository.findAll();
    }

    public Pengiriman getUserById(int id) {
        return pengirimanRepository.findById(id).orElse(null);
    }

    public Pengiriman addUser(Pengiriman per) {
        return pengirimanRepository.save(per);
    }

    public Pengiriman updateUser(int id, Pengiriman per) {
        per.setUserId(id);
        return pengirimanRepository.save(per);
    }

    public void deleteUser(int id) {
        pengirimanRepository.deleteById(id);
    }
}