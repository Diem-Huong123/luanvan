package com.example.login.service;

import com.example.login.model.User;
import com.example.login.reponsitory.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

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
}
