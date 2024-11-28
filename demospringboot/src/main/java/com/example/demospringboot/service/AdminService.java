package com.example.demospringboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demospringboot.entity.Admin;
import com.example.demospringboot.repository.AdminRepository;

import java.util.List;

@Service
public class AdminService {
    @Autowired
    private AdminRepository adminRepository;

    public List<Admin> getAllUsers() {
        return adminRepository.findAll();
    }

    public Admin getUserById(int id) {
        return adminRepository.findById(id).orElse(null);
    }

    public Admin addUser(Admin adm) {
        return adminRepository.save(adm);
    }

    public Admin updateUser(int id, Admin adm) {
        adm.setUserId(id);
        return adminRepository.save(adm);
    }

    public void deleteUser(int id) {
        adminRepository.deleteById(id);
    }

    public Admin login(String nama, String password) {
        Admin admin = adminRepository.findByNama(nama);
        if (admin != null && admin.getPassword().equals(password)) {
            return admin;
        }
        return null;
    }
}