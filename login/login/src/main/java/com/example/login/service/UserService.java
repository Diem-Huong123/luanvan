package com.example.login.service;

import com.example.login.model.SinhVien;
import com.example.login.model.User;
import com.example.login.reponsitory.SinhVienReponsitory;
import com.example.login.reponsitory.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SinhVienReponsitory sinhVienRepository;

    // Lưu thông tin người dùng
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    // Lấy thông tin người dùng theo username
    public Optional<User> getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    // Xóa người dùng theo username
    public void deleteUser(String username) {
        userRepository.deleteByUsername(username);
    }

    //

    public User updateUser(String username, User updatedUser) {
        Optional<User> existingUserOpt = userRepository.findByUsername(username);

        if (existingUserOpt.isPresent()) {
            User existingUser = existingUserOpt.get();

            // Cập nhật mật khẩu nếu có
            if (updatedUser.getPassword() != null && !updatedUser.getPassword().isEmpty()) {
                existingUser.setPassword(updatedUser.getPassword());
            }

            // Cập nhật thông tin SinhVien nếu có
            if (updatedUser.getSinhVien() != null) {
                SinhVien updatedSinhVien = updatedUser.getSinhVien();
                Optional<SinhVien> sinhVienOpt = sinhVienRepository.findById(updatedSinhVien.getMaSinhVien());

                if (sinhVienOpt.isPresent()) {
                    SinhVien sinhVien = sinhVienOpt.get();

                    // Cập nhật thông tin sinh viên (chỉ cập nhật nếu giá trị mới không null)
                    if (updatedSinhVien.getHoTen() != null) sinhVien.setHoTen(updatedSinhVien.getHoTen());
                    if (updatedSinhVien.getLop() != null) sinhVien.setLop(updatedSinhVien.getLop());
                    if (updatedSinhVien.getNganhHoc() != null) sinhVien.setNganhHoc(updatedSinhVien.getNganhHoc());
                    if (updatedSinhVien.getEmail() != null) sinhVien.setEmail(updatedSinhVien.getEmail());
                    if (updatedSinhVien.getGioiTinh() != null) sinhVien.setGioiTinh(updatedSinhVien.getGioiTinh());

                    sinhVienRepository.save(sinhVien); // Lưu cập nhật vào DB
                    existingUser.setSinhVien(sinhVien); // Gán lại vào User
                } else {
                    throw new RuntimeException("SinhVien không tồn tại!");
                }
            }

            return userRepository.save(existingUser); // Lưu lại User
        } else {
            throw new RuntimeException("User không tồn tại!");
        }
    }

}
