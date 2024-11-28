package com.example.demospringboot.entity;

import jakarta.persistence.*;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "pengiriman")
public class Pengiriman extends Customer {
    @Column(name = "resi")
    private int resi;

    @Column(name = "tanggal")
    private Date tanggal;

    @Column(name = "nama_barang")
    private String namaBarang;

    @Column(name = "kategori_barang")
    private String kategoriBarang;

    @Column(name = "jumlah_barang")
    private int jumlahBarang;

    @Column(name = "berat")
    private double berat;

    @Column(name = "status")
    private String status;

    @Column(name = "jenis_pengiriman")
    private String jenisPengiriman;

    public Pengiriman() {}

    public Pengiriman(String nama, String password, String email, int resi, Date tanggal, String namaBarang, String kategoriBarang, int jumlahBarang, double berat, String status, String jenisPengiriman) {
        super(nama, password, email);
        this.resi = resi;
        this.tanggal = tanggal;
        this.namaBarang = namaBarang;
        this.kategoriBarang = kategoriBarang;
        this.jumlahBarang = jumlahBarang;
        this.berat = berat;
        this.status = status;
        this.jenisPengiriman = jenisPengiriman;
    }

    // Getters and Setters
    public int getResi() {
        return resi;
    }

    public void setResi(int resi) {
        this.resi = resi;
    }

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public Date getTanggal() {
        return tanggal;
    }

    public void setTanggal(Date tanggal) {
        this.tanggal = tanggal;
    }

    public String getNamaBarang() {
        return namaBarang;
    }

    public void setNamaBarang(String namaBarang) {
        this.namaBarang = namaBarang;
    }

    public String getKategoriBarang() {
        return kategoriBarang;
    }

    public void setKategoriBarang(String kategoriBarang) {
        this.kategoriBarang = kategoriBarang;
    }

    public int getJumlahBarang() {
        return jumlahBarang;
    }

    public void setJumlahBarang(int jumlahBarang) {
        this.jumlahBarang = jumlahBarang;
    }

    public double getBerat() {
        return berat;
    }

    public void setBerat(double berat) {
        this.berat = berat;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getJenisPengiriman() {
        return jenisPengiriman;
    }

    public void setJenisPengiriman(String jenisPengiriman) {
        this.jenisPengiriman = jenisPengiriman;
    }
}
