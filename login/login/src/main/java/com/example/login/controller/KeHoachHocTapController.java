package com.example.login.controller;

import ch.qos.logback.core.model.Model;
import com.example.login.model.KeHoachHocTap;
import com.example.login.model.SinhVien;
import com.example.login.reponsitory.KeHoachHocTapRepository;
import com.example.login.service.KeHoachHocTapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/kehoachhoctap")
public class KeHoachHocTapController {
    @Autowired
    private KeHoachHocTapService keHoachHocTapService;
    // Thêm kế hoạch học tập mới
    @PostMapping
    public KeHoachHocTap createKeHoachHocTap(@RequestBody KeHoachHocTap keHoachHocTap) {
        return keHoachHocTapService.saveKeHoachHocTap(keHoachHocTap);
    }

    // Lấy danh sách tất cả kế hoạch học tập
    @GetMapping
    public List<KeHoachHocTap> getAllKeHoachHocTaps() {
        return keHoachHocTapService.getAllKeHoachHocTaps();
    }

    // Lấy kế hoạch học tập theo ID
    @GetMapping("/{id}")
    public Optional<KeHoachHocTap> getKeHoachHocTapById(@PathVariable Long id) {
        return keHoachHocTapService.getKeHoachHocTapById(id);
    }

    //Lay ke hoạch hoc tap theo mssv
    @GetMapping("/sinh-vien/{maSinhVien}")
    public List<KeHoachHocTap> getKeHoachHocTapBySinhVien(@PathVariable String maSinhVien) {
        return keHoachHocTapService.getKeHoachByMaSinhVien(maSinhVien);
    }

    // Xóa kế hoạch học tập theo ID
    @DeleteMapping("/{id}")
    public void deleteKeHoachHocTap(@PathVariable Long id) {
        keHoachHocTapService.deleteKeHoachHocTap(id);
    }

    //laytheomssv lay theo hocki
    @GetMapping("/sinh-vien/{maSinhVien}/hoc-ky/{maHocKy}")
    public List<KeHoachHocTap> getKeHoachHocTapBySinhVienAndHocKy(
            @PathVariable String maSinhVien,
            @PathVariable String maHocKy) {
        return keHoachHocTapService.getKeHoachBySinhVienAndHocKy(maSinhVien, maHocKy);
    }
}
