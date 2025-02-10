package com.example.login.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

import java.util.List;

@Entity
public class HocPhan {
    @Id
    @Column(nullable = false, unique = true, length = 20)
    private String maHocPhan;  // Mã học phần (Khóa chính)

    @Column(nullable = false, length = 100)
    private String tenHocPhan;  // Tên học phần

    @Column(nullable = false, length = 5)
    private String soTinChi;  // Số tín chỉ

    @Column(length = 500)
    private String moTa;  // Mô tả học phần

    public String getMaHocPhan() {
        return maHocPhan;
    }

    public void setMaHocPhan(String maHocPhan) {
        this.maHocPhan = maHocPhan;
    }

    public String getTenHocPhan() {
        return tenHocPhan;
    }

    public void setTenHocPhan(String tenHocPhan) {
        this.tenHocPhan = tenHocPhan;
    }

    public String getSoTinChi() {
        return soTinChi;
    }

    public void setSoTinChi(String soTinChi) {
        this.soTinChi = soTinChi;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

}
