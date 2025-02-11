package com.example.login.reponsitory;

import com.example.login.model.KeHoachHocTap;
import com.example.login.model.SinhVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KeHoachHocTapRepository extends JpaRepository<KeHoachHocTap, Long> {
//    List<KeHoachHocTap> findBySinhVien(SinhVien sinhVien);
    List<KeHoachHocTap> findBySinhVien_MaSinhVien(String sinhVien);

    // Lấy kế hoạch học tập theo mã sinh viên và mã học kỳ
    List<KeHoachHocTap> findBySinhVien_MaSinhVienAndHocKy_MaHocKy(String maSinhVien, String maHocKy);
}
