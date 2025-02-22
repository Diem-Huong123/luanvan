package com.example.login.model.B2110947;

import java.util.Set;

import com.example.login.model.HocPhan;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;

@Entity
public class NhomHoc {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_nhom_hoc")
    private int idNhomHoc;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idHocKyMonHoc", nullable = false)
    @JsonBackReference("hockymonhoc-nhomhoc")
    private HocKyMonHoc hocKyMonHoc;

    @Transient
    private int idHocKyMonHoc;

    @OneToMany(mappedBy = "nhomHoc", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference("nhomhoc-dangkyhocphan")
    @JsonIgnore
    private Set<DangKyHocPhan> dangKyHocPhans;


    private String maNhomHoc;
    private int thu;
    private int tietBatDau;
    private int soTiet;
    private String phongHoc;
    private int soLuongSV;
    private int idDangKyHocPhan;

    
    
    public int getIdDangKyHocPhan() {
        return idDangKyHocPhan;
    }
    public void setIdDangKyHocPhan(int idDangKyHocPhan) {
        this.idDangKyHocPhan = idDangKyHocPhan;
    }
    public int getIdNhomHoc() {
        return idNhomHoc;
    }
    public void setIdNhomHoc(int idNhomHoc) {
        this.idNhomHoc = idNhomHoc;
    }
    public String getMaNhom() {
        return maNhomHoc;
    }
    public void setMaNhom(String maNhom) {
        this.maNhomHoc = maNhom;
    }
    public int getThu() {
        return thu;
    }
    public void setThu(int thu) {
        this.thu = thu;
    }
    public int getTietBatDau() {
        return tietBatDau;
    }
    public void setTietBatDau(int tietBatDau) {
        this.tietBatDau = tietBatDau;
    }
    public int getSoTiet() {
        return soTiet;
    }
    public void setSoTiet(int soTiet) {
        this.soTiet = soTiet;
    }
    public String getPhongHoc() {
        return phongHoc;
    }
    public void setPhongHoc(String phongHoc) {
        this.phongHoc = phongHoc;
    }
    public int getSoLuongSV() {
        return soLuongSV;
    }
    public void setSoLuongSV(int soLuongSV) {
        this.soLuongSV = soLuongSV;
    }
    public int getIdHocKyMonHoc(){
        return this.idHocKyMonHoc;
    }
    public void setHocKyMonHoc(HocKyMonHoc hocKyMonHoc){
        this.hocKyMonHoc = hocKyMonHoc;
    }
    public NhomHoc(){
    }
    public NhomHoc(int idHocKyMonHoc, String maNhomHoc, int thu, int tietBatDau, int soTiet, String phongHoc,
            int soLuongSV) {
        this.idHocKyMonHoc = idHocKyMonHoc;
        this.maNhomHoc = maNhomHoc;
        this.thu = thu;
        this.tietBatDau = tietBatDau;
        this.soTiet = soTiet;
        this.phongHoc = phongHoc;
        this.soLuongSV = soLuongSV;
    }
    public HocKyMonHoc getHocKyMonHoc() {
        return hocKyMonHoc;
    }

    public HocPhan getHocPhan(){
        return this.hocKyMonHoc.getHocPhan();
    }
    public void setHocPhan(HocPhan hocPhan){
        this.hocKyMonHoc.setHocPhan(hocPhan);
    }
}
