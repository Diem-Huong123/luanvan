package com.example.login.service;

import com.example.login.model.HocKy;
import com.example.login.reponsitory.HocKyReponsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HocKyService {
    @Autowired
    private HocKyReponsitory hocKyRepository;

    // Lưu học kỳ
    public HocKy saveHocKy(HocKy hocKy) {
        return hocKyRepository.save(hocKy);
    }

    // Lấy tất cả các học kỳ
    public List<HocKy> getAllHocKys() {
        return hocKyRepository.findAll();
    }

    // Lấy học kỳ theo ID
    public Optional<HocKy> getHocKyById(String id) {
        return hocKyRepository.findById(id);
    }

    // Xóa học kỳ theo ID
    public void deleteHocKy(String id) {
        hocKyRepository.deleteById(id);
    }
}
