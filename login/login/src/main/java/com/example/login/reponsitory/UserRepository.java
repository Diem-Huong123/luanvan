package com.example.login.reponsitory;

import com.example.login.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,String> {

    // Tìm kiếm người dùng theo tên người dùng
    Optional<User> findByUsername(String username);
//        Optional<User> findByMaSinhVien(String maSinhVien);

    void deleteByUsername(String username);
//    // Kiểm tra sự tồn tại của người dùng theo tên người dùng
//    boolean existsByUsername(String username);
}
