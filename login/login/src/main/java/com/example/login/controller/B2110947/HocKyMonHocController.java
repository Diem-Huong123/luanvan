package com.example.login.controller.B2110947;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.login.DTO.HocKyMonHocDTO;
import com.example.login.model.B2110947.HocKyMonHoc;
import com.example.login.service.B2110947.HocKyMonHocService;;

@RestController
@RequestMapping("/api/hockymonhoc")
public class HocKyMonHocController {
    @Autowired
    private HocKyMonHocService hocKyMonHocService;

    @PostMapping
    public HocKyMonHoc createHocKyMonHoc(@RequestBody HocKyMonHoc hocKyMonHoc) {

        return hocKyMonHocService.saveHocKyMonHoc(hocKyMonHoc);
    }

    @GetMapping
    public List<HocKyMonHoc> getAllHocKyMonHoc() {
        return hocKyMonHocService.getAllHocKyMonHoc();
    }
    @GetMapping("/KhongSinhVien")
    public List<HocKyMonHocDTO> getAllHocKyMonHocKhongSinhVien(@RequestParam String maHocKy) {
    return hocKyMonHocService.getAllHocKyMonHocKhongSinhVien(maHocKy);
}

    @DeleteMapping
    public String deleteAllHocKyMonHoc() {
        return hocKyMonHocService.deleteAllHocKyMonHoc();
    }

}
