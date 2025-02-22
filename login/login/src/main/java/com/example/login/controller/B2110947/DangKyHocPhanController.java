package com.example.login.controller.B2110947;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.login.DTO.NhomHoc.NhomHocWithoutDangKyHocPhanDTO;
import com.example.login.model.B2110947.DangKyHocPhan;
import com.example.login.service.B2110947.DangKyHocPhanService;

@RestController
@RequestMapping("/api/dangkyhocphan")
public class DangKyHocPhanController {

    @Autowired
    DangKyHocPhanService dangKyHocPhanService;

    @PostMapping
    public ResponseEntity<?> createDangKyHocPhan(@RequestBody DangKyHocPhan dangKyHocPhan) {
        try {

            DangKyHocPhan result = dangKyHocPhanService.createDangKyHocPhan(dangKyHocPhan);

            if (result == null) {
                return ResponseEntity.status(HttpStatus.OK).body(
                        "1: Can early apply in NhomHoc, 2: Can't apply 2 NhomHoc of 1 Subject, 3: Conflict schedule !!!");
            }
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.OK).body("Conflict Schedule");
 
        }
    }

    @GetMapping
    public List<DangKyHocPhan> getAllDangKyHocPhan() {
        return dangKyHocPhanService.getAllDangKyHocPhan();
    }

    @GetMapping("/layNhomHocTheoMSSV")
    public List<NhomHocWithoutDangKyHocPhanDTO> getNhomHocByMaSinhVien(@RequestParam String maSinhVien) {
        return dangKyHocPhanService.getNhomHocByMaSinhVien(maSinhVien);
    }

    @DeleteMapping()
    public String deleteDangKyHocPhan(@RequestParam int iddangKyHocPhan) {
        return dangKyHocPhanService.deleteDangKyHocPhan(iddangKyHocPhan);
    }
}
