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

    public List<Pengiriman> getAllPengiriman() {
        return pengirimanRepository.findAll();
    }

    public Pengiriman getPengirimanByResi(int resi) {
        return pengirimanRepository.findById(resi).orElse(null);
    }

    public Pengiriman addPengiriman(Pengiriman pengiriman) {
        return pengirimanRepository.save(pengiriman);
    }

    public Pengiriman updatePengiriman(int resi, Pengiriman pengiriman) {
        if (pengirimanRepository.existsById(resi)) {
            pengiriman.setResi(resi);
            return pengirimanRepository.save(pengiriman);
        }
        return null;
    }

    public void deletePengiriman(int resi) {
        pengirimanRepository.deleteById(resi);
    }
}