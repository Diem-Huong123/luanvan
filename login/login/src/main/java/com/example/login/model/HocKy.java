package com.example.login.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

import com.example.login.model.B2110947.HocKyMonHoc;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class HocKy {
    @Id
    // @GeneratedValue(strategy = GenerationType.AUTO)
    // private Long maHocKy; // Mã học kỳ (khóa chính)
    @Column(nullable = false)
    private String maHocKy;

    @Column(nullable = false)
    private String tenHocKy; // "Học kỳ 1"

    @Column(nullable = false)
    private String namHoc; // "2024-2025"

    @Column(nullable = false)
    private LocalDate thoiGianBatDau; // Thời gian bắt đầu học kỳ

    @Column(nullable = false)
    private LocalDate thoiGianKetThuc; // Thời gian kết thúc học kỳ

    public String getMaHocKy() {
        return maHocKy;
    }

    public void setMaHocKy(String maHocKy) {
        this.maHocKy = maHocKy;
    }

    public String getTenHocKy() {
        return tenHocKy;
    }

    public void setTenHocKy(String tenHocKy) {
        this.tenHocKy = tenHocKy;
    }

    public String getNamHoc() {
        return namHoc;
    }

    public void setNamHoc(String namHoc) {
        this.namHoc = namHoc;
    }

    public LocalDate getThoiGianBatDau() {
        return thoiGianBatDau;
    }

    public void setThoiGianBatDau(LocalDate thoiGianBatDau) {
        this.thoiGianBatDau = thoiGianBatDau;
    }

    public LocalDate getThoiGianKetThuc() {
        return thoiGianKetThuc;
    }

    public void setThoiGianKetThuc(LocalDate thoiGianKetThuc) {
        this.thoiGianKetThuc = thoiGianKetThuc;
    }

    // B2110947 Insert

    public HocKy() {
    }

    public HocKy(String maHocKy, String tenHocKy, String namHoc, LocalDate thoiGianBatDau, LocalDate thoiGianKetThuc) {
        this.maHocKy = maHocKy;
        this.tenHocKy = tenHocKy;
        this.namHoc = namHoc;
        this.thoiGianBatDau = thoiGianBatDau;
        this.thoiGianKetThuc = thoiGianKetThuc;
    }

    @OneToMany(mappedBy = "hocKy", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference("hocky-hockymonhoc")
    @JsonIgnore
    private List<HocKyMonHoc> hocKyMonHocs;

    // ===============

}
