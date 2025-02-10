package com.example.login.controller;

import com.example.login.model.User;
import com.example.login.reponsitory.UserRepository;
import com.example.login.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;

//    @PostMapping("/login")
//    public String login(@RequestParam String username, @RequestParam String password) {
//        // In log để kiểm tra giá trị username và password
//        System.out.println("Username: " + username);
//        System.out.println("Password: " + password);
//
//        // Kiểm tra nếu username và password không rỗng
//        if (username == null || username.isEmpty() || password == null || password.isEmpty()) {
//            return "loginError";  // Trả về trang lỗi nếu thiếu thông tin
//        }
//
//        // Tìm kiếm user trong cơ sở dữ liệu
//        User user = userRepository.findByUsername(username).orElse(null);
//
//        // Kiểm tra nếu không tìm thấy user hoặc mật khẩu không đúng
//        if (user == null) {
//            return "loginError";  // Nếu không có user, trả về lỗi
//        }
//
//        if (!user.getPassword().equals(password)) {
//            return "loginError";  // Nếu mật khẩu không đúng, trả về lỗi
//        }
//
//        // Đăng nhập thành công
//        return "loginSuccess";  // Trả về trang thành công
//    }
//
//
//    @PostMapping("/createUsers")
//    public String createUsers() {
//        userService.createUsers();
//        return "2000 users created!";
//    }
//
//    @GetMapping("/loginPage")
//    public String showLoginPage() {
//        return "login"; // Trả về trang login.html
//    }

    // Thêm người dùng mới
    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    // Lấy thông tin người dùng theo username
    @GetMapping("/{username}")
    public Optional<User> getUserByUsername(@PathVariable String username) {
        return userService.getUserByUsername(username);
    }

    // Xóa người dùng theo username
    @DeleteMapping("/{username}")
    public void deleteUser(@PathVariable String username) {
        userService.deleteUser(username);
    }
}
