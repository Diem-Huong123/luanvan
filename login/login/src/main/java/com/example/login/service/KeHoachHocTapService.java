package com.example.login.service;

import com.example.login.model.KeHoachHocTap;
import com.example.login.model.SinhVien;
import com.example.login.reponsitory.KeHoachHocTapRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class KeHoachHocTapService {

    @Autowired
    private KeHoachHocTapRepository keHoachHocTapRepository;

    // Lưu kế hoạch học tập
    public KeHoachHocTap saveKeHoachHocTap(KeHoachHocTap keHoachHocTap) {
        return keHoachHocTapRepository.save(keHoachHocTap);
    }

    // Lấy tất cả kế hoạch học tập
    public List<KeHoachHocTap> getAllKeHoachHocTaps() {
        return keHoachHocTapRepository.findAll();
    }

    // Lấy kế hoạch học tập theo ID
    public Optional<KeHoachHocTap> getKeHoachHocTapById(Long id) {
        return keHoachHocTapRepository.findById(id);
    }

    // Xóa kế hoạch học tập theo ID
    public void deleteKeHoachHocTap(Long id) {
        keHoachHocTapRepository.deleteById(id);
    }

    public void addKeHoachHocTap(KeHoachHocTap keHoach) {
        keHoachHocTapRepository.save(keHoach);
    }


//    public List<KeHoachHocTap> getKeHoachBySinhVien(SinhVien sinhVien) {
//        return keHoachHocTapRepository.findBySinhVien(sinhVien);

}
