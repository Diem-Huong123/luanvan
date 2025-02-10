package com.example.login.reponsitory;

import com.example.login.model.KeHoachHocTap;
import com.example.login.model.SinhVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KeHoachHocTapRepository extends JpaRepository<KeHoachHocTap, Long> {
//    List<KeHoachHocTap> findBySinhVien(SinhVien sinhVien);
}
