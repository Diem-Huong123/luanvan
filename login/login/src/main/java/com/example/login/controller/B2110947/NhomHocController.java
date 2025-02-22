package com.example.login.controller.B2110947;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.login.model.B2110947.NhomHoc;
import com.example.login.service.B2110947.NhomHocService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/nhomhoc")
public class NhomHocController {

    @Autowired
    private NhomHocService nhomHocService;

    @PostMapping
    public NhomHoc createNhomHoc(@RequestBody NhomHoc nhomHoc){
        return nhomHocService.createNhomHoc(nhomHoc);
    }

    @GetMapping
    public List<NhomHoc> getAllNhomHoc(){
        return nhomHocService.getAllNhomHoc();
    }

    
}
