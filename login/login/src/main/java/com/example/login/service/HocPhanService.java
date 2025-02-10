package com.example.login.service;

import com.example.login.model.HocPhan;
import com.example.login.reponsitory.HocPhanReponsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HocPhanService {
    @Autowired
    private HocPhanReponsitory hocPhanRepository;

    // Lưu thông tin học phần
    public HocPhan saveHocPhan(HocPhan hocPhan) {
        return hocPhanRepository.save(hocPhan);
    }

    // Lấy danh sách tất cả học phần
    public List<HocPhan> getAllHocPhans() {
        return hocPhanRepository.findAll();
    }

    // Lấy thông tin học phần theo mã học phần
    public Optional<HocPhan> getHocPhanByMaHocPhan(String maHocPhan) {
        return hocPhanRepository.findById(maHocPhan);
    }

    // Xóa học phần theo mã học phần
    public void deleteHocPhan(String maHocPhan) {
        hocPhanRepository.deleteById(maHocPhan);
    }
}