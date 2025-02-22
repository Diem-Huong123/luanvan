package com.example.login.model.B2110947;

import com.example.login.model.SinhVien;
import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;

@Entity
@Table(uniqueConstraints = { @UniqueConstraint(columnNames = { "maSinhVien", "idNhomHoc" }) })
public class DangKyHocPhan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDangKyHocPhan;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "maSinhVien", nullable = false)
    @JsonBackReference("sinhvien-dangkyhocphan")
    private SinhVien sinhVien;

    @Transient
    private String maSinhVien;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "idNhomHoc", nullable = false)
    @JsonBackReference("nhomhoc-dangkyhocphan")
    private NhomHoc nhomHoc;

    @Transient
    private int idNhomHoc;

    public String getMaSinhVien() {
        return sinhVien != null ? sinhVien.getMaSinhVien() : maSinhVien;
    }

    public int getIdNhomHoc() {
        return nhomHoc != null ? nhomHoc.getIdNhomHoc() : idNhomHoc;
    }

    public void setSinhVien(SinhVien sinhVien) {
        this.sinhVien = sinhVien;
    }

    public void setNhomHoc(NhomHoc nhomHoc) {
        this.nhomHoc = nhomHoc;
    }

    public int getIdDangKyHocPhan() {
        return idDangKyHocPhan;
    }

    public void setIdDangKyHocPhan(int idDangKyHocPhan) {
        this.idDangKyHocPhan = idDangKyHocPhan;
    }
    

}
