// B2110947
package com.example.login.model.B2110947;

import java.util.Set;

import com.example.login.model.HocKy;
import com.example.login.model.HocPhan;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;

@Entity
public class HocKyMonHoc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idHocKyMonHoc;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "maHocPhan", nullable = false)
    @JsonBackReference("hocphan-hockymonhoc")
    private HocPhan hocPhan;

    // Chỉ dùng như biến tạm để lấy dữ liệu từ client
    @Transient
    private String maHocPhan;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "maHocKy", nullable = false)
    @JsonBackReference("hocky-hockymonhoc")
    private HocKy hocKy;

    // Chỉ dùng như biến tạm để lấy dữ liệu từ client
    @Transient
    private String maHocKy;

    @OneToMany(mappedBy = "hocKyMonHoc", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference("hockymonhoc-nhomhoc")
    @JsonIgnore

    private Set<NhomHoc> nhomHocs;

    public Set<NhomHoc> getNhomHocs() {
        return nhomHocs;
    }

    public void setNhomHocs(Set<NhomHoc> nhomHocs) {
        this.nhomHocs = nhomHocs;
    }

    public String getMaHocPhan() {
        return hocPhan != null ? hocPhan.getMaHocPhan() : maHocPhan;
    }

    public void setHocPhan(HocPhan hocPhan) {
        this.hocPhan = hocPhan;
    }

    public String getMaHocKy() {
        return hocKy != null ? hocKy.getMaHocKy() : maHocKy;
    }

    public void setHocKy(HocKy hocky) {
        this.hocKy = hocky;
    }

    public HocKyMonHoc() {

    }

    public HocKyMonHoc(String maHocPhan, String maHocKy) {
        this.maHocPhan = maHocPhan;
        this.maHocKy = maHocKy;
    }

    public int getId() {
        return this.idHocKyMonHoc;
    }

    public HocPhan getHocPhan() {
        return hocPhan;
    }

}
