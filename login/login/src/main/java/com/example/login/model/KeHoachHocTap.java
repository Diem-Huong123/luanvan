package com.example.login.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class KeHoachHocTap {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  // ID tự tăng, khóa chính của bảng

    @ManyToOne
    @JoinColumn(name = "maSinhVien", referencedColumnName = "maSinhVien", nullable = false)
    private SinhVien sinhVien;  // Liên kết với bảng SinhVien (một kế hoạch học tập của một sinh viên)

    @ManyToOne
    @JoinColumn(name = "maHocKy", referencedColumnName = "maHocKy", nullable = false)
    private HocKy hocKy;  // Liên kết với bảng HocKy (một kế hoạch học tập trong một học kỳ)

    @ManyToMany
    @JoinTable(
            name = "kehoach_hocphanhoc",
            joinColumns = @JoinColumn(name = "keHoachHocTap_id"),
            inverseJoinColumns = @JoinColumn(name = "maHocPhan")
    )
    private List<HocPhan> hocPhans;  // Liên kết với bảng HocPhan (một kế hoạch học tập có thể có nhiều học phần)

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public SinhVien getSinhVien() {
        return sinhVien;
    }

    public void setSinhVien(SinhVien sinhVien) {
        this.sinhVien = sinhVien;
    }

    public HocKy getHocKy() {
        return hocKy;
    }

    public void setHocKy(HocKy hocKy) {
        this.hocKy = hocKy;
    }

    public List<HocPhan> getHocPhans() {
        return hocPhans;
    }

    public void setHocPhans(List<HocPhan> hocPhans) {
        this.hocPhans = hocPhans;
    }
}
