package com.example.login.reponsitory.B2110947;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.login.DTO.NhomHoc.NhomHocWithoutDangKyHocPhanDTO;
import com.example.login.model.SinhVien;
import com.example.login.model.B2110947.DangKyHocPhan;
import com.example.login.model.B2110947.HocKyMonHoc;
import com.example.login.model.B2110947.NhomHoc;

@Repository
public interface DangKyHocPhanRepositoty extends JpaRepository<DangKyHocPhan, Integer> {
        boolean existsBySinhVienAndNhomHoc_HocKyMonHoc(SinhVien sinhVien, HocKyMonHoc hocKyMonHoc);

        // @Query("SELECT dk.nhomHoc FROM DangKyHocPhan dk WHERE dk.sinhVien.maSinhVien=
        // :maSinhVien")
        @Query(value = """
                        SELECT dkhp.id_dang_ky_hoc_phan,nh.id_nhom_hoc,nh.ma_nhom_hoc,nh.phong_hoc,nh.so_luongsv,nh.so_tiet,nh.thu,nh.tiet_bat_dau, sv.ho_ten, hp.ten_hoc_phan,hkmh.id_hoc_ky_mon_hoc
                        FROM sinh_vien sv, nhom_hoc nh, hoc_ky_mon_hoc hkmh, hoc_phan hp, dang_ky_hoc_phan dkhp
                        WHERE sv.ma_sinh_vien = dkhp.ma_sinh_vien
                        AND dkhp.id_nhom_hoc = nh.id_nhom_hoc
                        AND nh.id_hoc_ky_mon_hoc = hkmh.id_hoc_ky_mon_hoc
                        AND hkmh.ma_hoc_phan = hp.ma_hoc_phan
                        AND sv.ma_sinh_vien = :maSinhVien
                        """, nativeQuery = true)
        List<NhomHoc> findNhomHocByMaSinhVien(String maSinhVien);

        @Query(value = """
                        SELECT nh.*
                        FROM sinh_vien sv
                        JOIN dang_ky_hoc_phan dkhp ON sv.ma_sinh_vien = dkhp.ma_sinh_vien
                        JOIN nhom_hoc nh ON dkhp.id_nhom_hoc = nh.id_nhom_hoc
                        WHERE sv.ma_sinh_vien = :maSinhVien
                        """, nativeQuery = true)
        List<NhomHoc> findAllNhomHocByMaSinhVien(String maSinhVien);
}
