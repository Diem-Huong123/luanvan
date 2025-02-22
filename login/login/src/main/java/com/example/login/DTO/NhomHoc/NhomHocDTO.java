package com.example.login.DTO.NhomHoc;

public class NhomHocDTO {
    private int idNhomHoc;
    private int thu;
    private int tietBatDau;
    private int soTiet;
    private String phongHoc;
    private int soLuongSV;
    private String maNhomHoc;
    private int idHocKyMonHoc;


    public NhomHocDTO(int idNhomHoc,int idHocKyMonHoc, int thu, int tietBatDau, int soTiet,String maNhomHoc, String phongHoc, int soLuongSV) {
        this.idNhomHoc = idNhomHoc;
        this.thu = thu;
        this.tietBatDau = tietBatDau;
        this.soTiet = soTiet;
        this.phongHoc = phongHoc;
        this.soLuongSV = soLuongSV;
        this.maNhomHoc = maNhomHoc;
        this.idHocKyMonHoc = idHocKyMonHoc;
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

    public String getMaNhomHoc() {
        return maNhomHoc;
    }

    public void setMaNhomHoc(String maNhomHoc) {
        this.maNhomHoc = maNhomHoc;
    }

    public int getIdHocKyMonHoc() {
        return idHocKyMonHoc;
    }

    public void setIdHocKyMonHoc(int idHocKyMonHoc) {
        this.idHocKyMonHoc = idHocKyMonHoc;
    }
    
}

