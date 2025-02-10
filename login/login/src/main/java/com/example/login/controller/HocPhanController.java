package com.example.login.controller;
import com.example.login.model.HocPhan;
import com.example.login.service.HocPhanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/hocphan")
public class HocPhanController {
    @Autowired
    private HocPhanService hocPhanService;

    // Thêm học phần mới
    @PostMapping
    public HocPhan createHocPhan(@RequestBody HocPhan hocPhan) {
        return hocPhanService.saveHocPhan(hocPhan);
    }

    // Lấy danh sách tất cả học phần
    @GetMapping
    public List<HocPhan> getAllHocPhans() {
        return hocPhanService.getAllHocPhans();
    }

    // Lấy học phần theo mã học phần
    @GetMapping("/{maHocPhan}")
    public Optional<HocPhan> getHocPhanByMaHocPhan(@PathVariable String maHocPhan) {
        return hocPhanService.getHocPhanByMaHocPhan(maHocPhan);
    }

    // Xóa học phần theo mã học phần
    @DeleteMapping("/{maHocPhan}")
    public void deleteHocPhan(@PathVariable String maHocPhan) {
        hocPhanService.deleteHocPhan(maHocPhan);
    }
}
