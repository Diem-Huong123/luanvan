package com.example.login.model;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // Tự động tạo UUID
    private UUID id;

    @Column(nullable = false, unique = true)
    private String username;  // Tên đăng nhập

    @Column(nullable = false)
    private String password;  // Mật khẩu

    @OneToOne
    @JoinColumn(name = "maSinhVien", referencedColumnName = "maSinhVien", nullable = false)
    private SinhVien sinhVien; // Liên kết với SinhVien

    // Getter và Setter

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public SinhVien getSinhVien() {
        return sinhVien;
    }

    public void setSinhVien(SinhVien sinhVien) {
        this.sinhVien = sinhVien;
    }
}
