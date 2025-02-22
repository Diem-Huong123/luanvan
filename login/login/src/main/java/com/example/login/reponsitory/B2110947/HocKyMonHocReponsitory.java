package com.example.login.reponsitory.B2110947;

import org.springframework.stereotype.Repository;
import com.example.login.model.B2110947.HocKyMonHoc;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface HocKyMonHocReponsitory extends JpaRepository<HocKyMonHoc, Integer> {
}
