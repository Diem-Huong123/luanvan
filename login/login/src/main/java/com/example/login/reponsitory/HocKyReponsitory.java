package com.example.login.reponsitory;

import com.example.login.model.HocKy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HocKyReponsitory extends JpaRepository<HocKy, String> {
}
