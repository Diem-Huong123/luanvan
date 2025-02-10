package com.example.login.service;

import com.example.login.model.SinhVien;
import com.example.login.reponsitory.SinhVienReponsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SinhVienService {

    @Autowired
    private SinhVienReponsitory sinhVienRepository;

    public SinhVien saveSinhVien(SinhVien sinhVien) {
        return sinhVienRepository.save(sinhVien);
    }

    public List<SinhVien> getAllSinhViens() {
        return sinhVienRepository.findAll();
    }

    public Optional<SinhVien> getSinhVienByMaSinhVien(String maSinhVien) {
        return sinhVienRepository.findById(maSinhVien);
    }

    public void deleteSinhVien(String maSinhVien) {
        sinhVienRepository.deleteById(maSinhVien);
    }
}
