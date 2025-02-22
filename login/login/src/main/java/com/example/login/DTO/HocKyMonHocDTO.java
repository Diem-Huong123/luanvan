package com.example.login.DTO;

import java.util.List;

import com.example.login.DTO.NhomHoc.NhomHocDTO;
import com.example.login.model.HocPhan;

public class HocKyMonHocDTO {
    private String maHocPhan;
    private String maHocKy;
    private List<NhomHocDTO> nhomHocs;
    private HocPhanDTO hocPhan;

    public HocKyMonHocDTO(String maHocPhan, String maHocKy, HocPhanDTO hocPhan, List<NhomHocDTO> nhomHocs) {
        this.maHocPhan = maHocPhan;
        this.maHocKy = maHocKy;
        this.nhomHocs = nhomHocs;
        this.hocPhan = hocPhan;
    }

    public HocKyMonHocDTO() {
        //TODO Auto-generated constructor stub
    }

    // Getters and Setters
    public String getMaHocPhan() {
        return maHocPhan;
    }

    public void setMaHocPhan(String maHocPhan) {
        this.maHocPhan = maHocPhan;
    }

    public String getMaHocKy() {
        return maHocKy;
    }

    public void setMaHocKy(String maHocKy) {
        this.maHocKy = maHocKy;
    }

    public List<NhomHocDTO> getNhomHocs() {
        return nhomHocs;
    }

    public void setNhomHocs(List<NhomHocDTO> nhomHocs) {
        this.nhomHocs = nhomHocs;
    }

    public HocPhanDTO getHocPhan() {
        return hocPhan;
    }
    public void setHocPhan(HocPhanDTO hocPhan) {
        this.hocPhan = hocPhan;
    }
    

}
