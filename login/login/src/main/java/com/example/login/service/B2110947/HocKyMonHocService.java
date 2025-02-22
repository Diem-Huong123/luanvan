package com.example.login.service.B2110947;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.login.DTO.HocKyMonHocDTO;
import com.example.login.DTO.HocPhanDTO;
import com.example.login.DTO.NhomHoc.NhomHocDTO;
import com.example.login.model.HocKy;
import com.example.login.model.HocPhan;
import com.example.login.model.B2110947.HocKyMonHoc;
import com.example.login.reponsitory.HocKyReponsitory;
import com.example.login.reponsitory.HocPhanReponsitory;
import com.example.login.reponsitory.B2110947.HocKyMonHocReponsitory;

@Service
public class HocKyMonHocService {

    @Autowired
    private HocKyMonHocReponsitory hocKyMonHocRepository;

    @Autowired
    private HocPhanReponsitory hocPhanRepository;

    @Autowired
    private HocKyReponsitory hocKyRepository;

    public HocKyMonHoc saveHocKyMonHoc(HocKyMonHoc hocKyMonHoc) {

        // Lấy dữ liệu của "đối tượng HocPhan và HocKy" từ trong HocKyMonHoc Model
        HocPhan hocPhan = hocPhanRepository.findById(hocKyMonHoc.getMaHocPhan())
                .orElseThrow(() -> new RuntimeException("HocPhan not found"));
        HocKy hocKy = hocKyRepository.findById(hocKyMonHoc.getMaHocKy())
                .orElseThrow(() -> new RuntimeException("HocKy not found"));
        // Thêm các đối tượng vào đối tượng cần tạo
        hocKyMonHoc.setHocPhan(hocPhan);
        hocKyMonHoc.setHocKy(hocKy);

        return hocKyMonHocRepository.save(hocKyMonHoc);
    }

    public List<HocKyMonHoc> getAllHocKyMonHoc() {
        return hocKyMonHocRepository.findAll();
    }

    public List<HocKyMonHocDTO> getAllHocKyMonHocKhongSinhVien(String maHocKy) {
        List<HocKyMonHoc> hocKyMonHocs = hocKyMonHocRepository.findAll();

        return hocKyMonHocs.stream()
        .filter(hocKyMonHoc -> hocKyMonHoc.getMaHocKy().equals(maHocKy))
        .map(hocKyMonHoc -> new HocKyMonHocDTO(
                hocKyMonHoc.getMaHocPhan(),
                hocKyMonHoc.getMaHocKy(),
                // Fix: Convert HocPhan to HocPhanDTO
                new HocPhanDTO(
                    hocKyMonHoc.getHocPhan().getMaHocPhan(),
                    hocKyMonHoc.getHocPhan().getTenHocPhan(),
                    hocKyMonHoc.getHocPhan().getSoTinChi(),
                    hocKyMonHoc.getHocPhan().getMoTa()
                ),
                // Fix: This is correct
                hocKyMonHoc.getNhomHocs().stream()
                        .map(nhomHoc -> new NhomHocDTO(
                                nhomHoc.getIdNhomHoc(),
                                nhomHoc.getIdHocKyMonHoc(),
                                nhomHoc.getThu(),
                                nhomHoc.getTietBatDau(),
                                nhomHoc.getSoTiet(),
                                nhomHoc.getMaNhom(),
                                nhomHoc.getPhongHoc(),
                                nhomHoc.getSoLuongSV()))
                        .collect(Collectors.toList())))
        .collect(Collectors.toList());
    }

    public String deleteAllHocKyMonHoc() {
        hocKyMonHocRepository.deleteAll();
        return "Delete all HocKyMonHoc Success";
    }
}
