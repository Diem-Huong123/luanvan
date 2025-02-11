package com.example.login.reponsitory;

import com.example.login.model.SinhVien;
import com.example.login.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SinhVienReponsitory extends JpaRepository<SinhVien, String> {
    Optional<SinhVien> findByMaSinhVien(String maSinhVien);
}
