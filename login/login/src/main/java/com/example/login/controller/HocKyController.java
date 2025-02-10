package com.example.login.controller;


import com.example.login.model.HocKy;
import com.example.login.service.HocKyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/hocky")
public class HocKyController {

    @Autowired
    private HocKyService hocKyService;

    // Thêm học kỳ mới
    @PostMapping
    public HocKy createHocKy(@RequestBody HocKy hocKy) {
        return hocKyService.saveHocKy(hocKy);
    }

    // Lấy danh sách tất cả học kỳ
    @GetMapping
    public List<HocKy> getAllHocKys() {
        return hocKyService.getAllHocKys();
    }

    // Lấy học kỳ theo ID
    @GetMapping("/{id}")
    public Optional<HocKy> getHocKyById(@PathVariable String id) {
        return hocKyService.getHocKyById(id);
    }

    // Xóa học kỳ theo ID
    @DeleteMapping("/{id}")
    public void deleteHocKy(@PathVariable String id) {
        hocKyService.deleteHocKy(id);
    }
}