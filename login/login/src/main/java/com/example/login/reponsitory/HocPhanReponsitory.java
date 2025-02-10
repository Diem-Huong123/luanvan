package com.example.login.reponsitory;

import com.example.login.model.HocPhan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HocPhanReponsitory extends JpaRepository<HocPhan, String> {
}
