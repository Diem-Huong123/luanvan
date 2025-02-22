package com.example.login.service.B2110947;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.login.model.B2110947.HocKyMonHoc;
import com.example.login.model.B2110947.NhomHoc;
import com.example.login.reponsitory.B2110947.HocKyMonHocReponsitory;
import com.example.login.reponsitory.B2110947.NhomHocReponsitory;

@Service
public class NhomHocService {

    @Autowired
    private NhomHocReponsitory nhomHocReponsitory;

    @Autowired
    private HocKyMonHocReponsitory hocKyMonHocReponsitory;

    public NhomHoc createNhomHoc(NhomHoc nhomHoc) {
        HocKyMonHoc hocKyMonHoc = hocKyMonHocReponsitory.findById(nhomHoc.getIdHocKyMonHoc())
                .orElseThrow(() -> new RuntimeException("HocKyMonHoc not found"));

        nhomHoc.setHocKyMonHoc(hocKyMonHoc);

        return nhomHocReponsitory.save(nhomHoc);
    }

    public List<NhomHoc> getAllNhomHoc(){
        return nhomHocReponsitory.findAll();
    }
}
