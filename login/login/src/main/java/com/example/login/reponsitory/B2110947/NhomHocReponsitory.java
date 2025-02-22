package com.example.login.reponsitory.B2110947;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.login.model.B2110947.NhomHoc;

@Repository
public interface NhomHocReponsitory extends JpaRepository<NhomHoc, Integer> {
}