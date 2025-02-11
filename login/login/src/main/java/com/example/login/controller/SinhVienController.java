package com.example.login.controller;

import com.example.login.model.SinhVien;
import com.example.login.service.SinhVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/sinhvien")
public class SinhVienController {

    @Autowired
    private SinhVienService sinhVienService;

    @PostMapping
    public SinhVien createSinhVien(@RequestBody SinhVien sinhVien) {
        return sinhVienService.saveSinhVien(sinhVien);
    }

    //lay thong tin sinh vien
    @GetMapping
    public List<SinhVien> getAllSinhViens() {
        return sinhVienService.getAllSinhViens();
    }

    @GetMapping("/{maSinhVien}")
    public Optional<SinhVien> getSinhVienByMaSinhVien(@PathVariable String maSinhVien) {
        return sinhVienService.getSinhVienByMaSinhVien(maSinhVien);
    }



    //xóa tt sinh vien
    @DeleteMapping("/{maSinhVien}")
    public void deleteSinhVien(@PathVariable String maSinhVien) {
        sinhVienService.deleteSinhVien(maSinhVien);
    }

}
