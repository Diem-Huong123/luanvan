package com.example.login.DTO.NhomHoc;

import com.example.login.model.HocPhan;
import com.example.login.model.B2110947.HocKyMonHoc;

public class NhomHocWithoutDangKyHocPhanDTO {
    private int idNhomHoc;
    private int thu;
    private int tietBatDau;
    private int soTiet;
    private String phongHoc;
    private int soLuongSV;
    private String maNhom;
    private HocPhan hocPhan;
    private int idDangKyHocPhan;


    
    public NhomHocWithoutDangKyHocPhanDTO() {
    }
    public NhomHocWithoutDangKyHocPhanDTO(int idNhomHoc, int idDangKyHocPhan, HocPhan hocPhan, int thu, int tietBatDau, int soTiet, String phongHoc,
            String maNhom) {
        this.idNhomHoc = idNhomHoc;
        this.thu = thu;
        this.tietBatDau = tietBatDau;
        this.soTiet = soTiet;
        this.phongHoc = phongHoc;
        this.maNhom = maNhom;
        this.hocPhan = hocPhan;
        this.idDangKyHocPhan = idDangKyHocPhan;
    }
    
    public int getIdNhomHoc() {
        return idNhomHoc;
    }
    public void setIdNhomHoc(int idNhomHoc) {
        this.idNhomHoc = idNhomHoc;
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
    public String getMaNhom() {
        return maNhom;
    }
    public void setMaNhom(String maNhom) {
        this.maNhom = maNhom;
    }
    public HocPhan getHocPhan() {
        return hocPhan;
    }
    public void setHocPhan(HocPhan hocPhan) {
        this.hocPhan = hocPhan;
    }
    public int getIdDangKyHocPhan() {
        return idDangKyHocPhan;
    }
    public void setIdDangKyHocPhan(int idDangKyHocPhan) {
        this.idDangKyHocPhan = idDangKyHocPhan;
    }
}
