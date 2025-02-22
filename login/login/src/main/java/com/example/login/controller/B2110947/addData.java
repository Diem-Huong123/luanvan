package com.example.login.controller.B2110947;

import java.time.LocalDate;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.login.model.HocKy;
import com.example.login.model.HocPhan;
import com.example.login.model.B2110947.HocKyMonHoc;
import com.example.login.model.B2110947.NhomHoc;
import com.example.login.reponsitory.HocKyReponsitory;
import com.example.login.reponsitory.HocPhanReponsitory;
import com.example.login.reponsitory.B2110947.HocKyMonHocReponsitory;
import com.example.login.reponsitory.B2110947.NhomHocReponsitory;
import com.example.login.service.B2110947.HocKyMonHocService;;

@RestController
@RequestMapping("/api")
public class addData {
    @Autowired
    private HocKyReponsitory hocKyRepository;

    @Autowired
    private HocPhanReponsitory hocPhanRepository;

    @Autowired
    private HocKyMonHocReponsitory hocKyMonHocReponsitory;

    @Autowired
    private HocKyMonHocService hocKyMonHocService;

    @Autowired
    private NhomHocReponsitory nhomHocReponsitory;

    @GetMapping("/addData")
    public String addTempTempData() {
        // Xóa dữ liệu cũ
        hocKyRepository.deleteAll();
        hocPhanRepository.deleteAll();
        hocKyMonHocReponsitory.deleteAll();
        nhomHocReponsitory.deleteAll();

        // Tạo 2 Học Kỳ
        HocKy hk1 = new HocKy("HK1", "Học Kỳ 1", "2024", LocalDate.of(2024, 1, 1), LocalDate.of(2024, 5, 31));
        HocKy hk2 = new HocKy("HK2", "Học Kỳ 2", "2024", LocalDate.of(2024, 6, 1), LocalDate.of(2024, 12, 31));
        hocKyRepository.saveAll(Arrays.asList(hk1, hk2));

        // Tạo 5 Học Phần
        HocPhan hp1 = new HocPhan("CT101", "Lập trình Java", "3", "Môn lập trình căn bản");
        HocPhan hp2 = new HocPhan("CT102", "Cấu trúc dữ liệu", "4", "Môn về cấu trúc dữ liệu");
        HocPhan hp3 = new HocPhan("CT103", "Hệ điều hành", "3", "Môn học về hệ điều hành");
        HocPhan hp4 = new HocPhan("CT104", "Lập trình Web", "3", "Môn về phát triển web");
        HocPhan hp5 = new HocPhan("CT105", "Trí tuệ nhân tạo", "4", "Môn về AI và Machine Learning");
        hocPhanRepository.saveAll(Arrays.asList(hp1, hp2, hp3, hp4, hp5));

        // Thêm HocKyMonHoc cho tất cả HocPhan mở trong HK1
        for (HocPhan hocPhan : Arrays.asList(hp1, hp2, hp3, hp4, hp5)) {
            HocKyMonHoc hkmh = new HocKyMonHoc(hocPhan.getMaHocPhan(), "HK1");
            createHocKyMonHoc(hkmh);

            // Lấy HocKyMonHoc vừa tạo
            HocKyMonHoc savedHocKyMonHoc = hocKyMonHocReponsitory.findById(hkmh.getId())
                    .orElseThrow(() -> new RuntimeException("❌ Không tìm thấy HocKyMonHoc vừa tạo"));

            // Tạo 5 NhomHoc với `tietBatDau` chỉ có thể là 1 hoặc 6
            for (int i = 1; i <= 5; i++) {
                int tietBatDau = (i % 2 == 0) ? 6 : 1; // Chẵn => 6, Lẻ => 1
                createNhomHoc(new NhomHoc(
                        savedHocKyMonHoc.getId(),
                        "NH" + i,
                        1 + i,
                        tietBatDau,
                        3, // soTiet luôn là 3
                        "Phòng 10" + i,
                        30 + i * 5));
            }
        }

        return "✅ Successfully added HocKy, HocPhan, multiple HocKyMonHoc, and NhomHoc!";
    }

    public void createHocKyMonHoc(@RequestBody HocKyMonHoc hocKyMonHoc) {
        // Lấy dữ liệu của "đối tượng HocPhan và HocKy" từ trong HocKyMonHoc Model
        HocPhan hocPhan = hocPhanRepository.findById(hocKyMonHoc.getMaHocPhan())
                .orElseThrow(() -> new RuntimeException("HocPhan not found"));
        HocKy hocKy = hocKyRepository.findById(hocKyMonHoc.getMaHocKy())
                .orElseThrow(() -> new RuntimeException("HocKy not found"));
        // Thêm các đối tượng vào đối tượng cần tạo
        hocKyMonHoc.setHocPhan(hocPhan);
        hocKyMonHoc.setHocKy(hocKy);

        hocKyMonHocService.saveHocKyMonHoc(hocKyMonHoc);
    }

    public void createNhomHoc(NhomHoc nhomHoc) {
        HocKyMonHoc hocKyMonHoc = hocKyMonHocReponsitory.findById(nhomHoc.getIdHocKyMonHoc())
                .orElseThrow(() -> new RuntimeException("HocKyMonHoc not found"));

        nhomHoc.setHocKyMonHoc(hocKyMonHoc);

        nhomHocReponsitory.save(nhomHoc);
    }
}