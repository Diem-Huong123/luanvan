package com.example.login.service.B2110947;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.example.login.DTO.NhomHoc.NhomHocDTO;
import com.example.login.DTO.NhomHoc.NhomHocWithoutDangKyHocPhanDTO;
import com.example.login.model.HocPhan;
import com.example.login.model.SinhVien;
import com.example.login.model.B2110947.DangKyHocPhan;
import com.example.login.model.B2110947.HocKyMonHoc;
import com.example.login.model.B2110947.NhomHoc;
import com.example.login.reponsitory.B2110947.DangKyHocPhanRepositoty;
import com.example.login.reponsitory.B2110947.NhomHocReponsitory;
import com.example.login.reponsitory.SinhVienReponsitory;

@Service
public class DangKyHocPhanService {

    @Autowired
    SinhVienReponsitory sinhVienReponsitory;

    @Autowired
    DangKyHocPhanRepositoty dangKyHocPhanRepository;

    @Autowired
    NhomHocReponsitory nhomHocReponsitory;

    public DangKyHocPhan createDangKyHocPhan(DangKyHocPhan dangKyHocPhan) {
        try {

            SinhVien sinhVien = sinhVienReponsitory.findById(dangKyHocPhan.getMaSinhVien())
                    .orElseThrow(() -> new RuntimeException("SinhVien not found"));

            NhomHoc nhomHoc = nhomHocReponsitory.findById(dangKyHocPhan.getIdNhomHoc())
                    .orElseThrow(() -> new RuntimeException("NhomHoc not found"));

            // UPDATE call function check confict
            if (!checkConflictNhomHoc(nhomHoc, sinhVien)) {
                return null;
            }
            // Check SinhVien have register to NhomHoc of HocKyMonHoc
            HocKyMonHoc hocKyMonHoc = nhomHoc.getHocKyMonHoc();

            boolean isAlreadyRegistered = dangKyHocPhanRepository.existsBySinhVienAndNhomHoc_HocKyMonHoc(sinhVien,
                    hocKyMonHoc);

            if (isAlreadyRegistered) {
                System.out.println("SinhVien has already registered a NhomHoc in this HocKyMonHoc");
                return null;
            }
            // ==================================
            dangKyHocPhan.setSinhVien(sinhVien);
            dangKyHocPhan.setNhomHoc(nhomHoc);

            return dangKyHocPhanRepository.save(dangKyHocPhan);

        } catch (DataIntegrityViolationException e) {
            return null;
        }
    }

    public List<DangKyHocPhan> getAllDangKyHocPhan() {
        return dangKyHocPhanRepository.findAll();
    }

    public List<NhomHocWithoutDangKyHocPhanDTO> getNhomHocByMaSinhVien(String maSinhVien) {
        return dangKyHocPhanRepository.findNhomHocByMaSinhVien(maSinhVien)
                .stream()
                .map(nh -> new NhomHocWithoutDangKyHocPhanDTO(
                        nh.getIdNhomHoc(),
                        nh.getIdDangKyHocPhan(),
                        nh.getHocPhan(),
                        nh.getThu(),
                        nh.getTietBatDau(),
                        nh.getSoTiet(),
                        nh.getPhongHoc(),
                        nh.getMaNhom()))
                .collect(Collectors.toList());
    }

    public String deleteDangKyHocPhan(int iddangKyHocPhan) {
        dangKyHocPhanRepository.deleteById(iddangKyHocPhan);
        return "SinhVien complete delete registed NhomHoc";
    }

    public boolean checkConflictNhomHoc(NhomHoc nhomHoc, SinhVien sinhVien) {
        List<NhomHoc> registeredNhomList = dangKyHocPhanRepository
                .findAllNhomHocByMaSinhVien(sinhVien.getMaSinhVien());
        int newRegisterThu = nhomHoc.getThu();
        int newRegisterTietBatDau = nhomHoc.getTietBatDau();

        // return "true" if any of "Registed NhomHoc" is matching
        boolean hasConflict = registeredNhomList.stream().anyMatch(registeredNhom -> {
            int registeredThu = registeredNhom.getThu();
            int registeredTietBatDau = registeredNhom.getTietBatDau();
            int registeredSoTiet = registeredNhom.getSoTiet();

            List<Integer> registeredTietRange = IntStream
                    .range(registeredTietBatDau, registeredTietBatDau + registeredSoTiet)
                    .boxed()
                    .collect(Collectors.toList());

            // Check conflict with the new HocPhan
            return registeredThu == newRegisterThu &&
                    registeredTietRange.contains(newRegisterTietBatDau);
        });

        if (hasConflict) {
            throw new IllegalArgumentException("Conflict Schedule, Can' Register !!!");
        }

        return true; // No conflicts, allow registration

    }
}
