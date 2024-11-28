package com.example.demospringboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demospringboot.entity.Kurir;
import com.example.demospringboot.repository.KurirRepository;

import java.util.List;

@Service
public class KurirService {
    @Autowired
    private KurirRepository kurirRepository;

    public List<Kurir> getAllUsers() {
        return kurirRepository.findAll();
    }

    public Kurir getUserById(int id) {
        return kurirRepository.findById(id).orElse(null);
    }

    public Kurir addUser(Kurir kur) {
        return kurirRepository.save(kur);
    }

    public Kurir updateUser(int id, Kurir kur) {
        kur.setUserId(id);
        return kurirRepository.save(kur);
    }

    public void deleteUser(int id) {
        kurirRepository.deleteById(id);
    }

    public Kurir login(String nama, String password) {
        Kurir kurir = kurirRepository.findByNama(nama);
        if (kurir != null && kurir.getPassword().equals(password)) {
            return kurir;
        }
        return null;
    }
}