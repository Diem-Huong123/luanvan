package com.example.login.model;

import java.util.Set;

import com.example.login.model.B2110947.DangKyHocPhan;
import com.example.login.model.B2110947.NhomHoc;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;

@Entity
public class SinhVien {
    @Id
    @Column(nullable = false, unique = true, length = 20)
    private String maSinhVien; // Mã sinh viên

    @Column(nullable = false, length = 50)
    private String hoTen; // Họ và tên

    @Column(nullable = false, length = 50)
    private String lop; // Lớp sinh viên

    @Column(nullable = false, length = 50)
    private String nganhHoc; // Ngành học

    @Column(nullable = false, length = 100, unique = true)
    private String email; // Email sinh viên

    @Column(nullable = false, length = 10)
    private String gioiTinh; // Giới tính (Nam/Nữ)

    // getter and setter
    public String getMaSinhVien() {
        return maSinhVien;
    }

    public void setMaSinhVien(String maSinhVien) {
        this.maSinhVien = maSinhVien;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getLop() {
        return lop;
    }

    public void setLop(String lop) {
        this.lop = lop;
    }

    public String getNganhHoc() {
        return nganhHoc;
    }

    public void setNganhHoc(String nganhHoc) {
        this.nganhHoc = nganhHoc;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    // B2110947 insert
    @OneToMany(mappedBy = "sinhVien", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference("sinhvien-dangkyhocphan")
    @JsonIgnore
    private Set<DangKyHocPhan> dangKyHocPhan;

    // ===============
}
