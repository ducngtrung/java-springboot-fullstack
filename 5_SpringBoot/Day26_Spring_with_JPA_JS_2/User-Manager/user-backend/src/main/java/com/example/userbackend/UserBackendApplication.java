package com.example.userbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// B1: Thêm dependencies vào file pom.xml
// B2: Thêm cấu hình database vào file application.properties
// B3: Sửa model User thành entity User
// B4: Chạy ứng dụng để tạo database và table
// B5: Sửa UserRepository để query từ database (các tác vụ tìm kiếm)
// B6: Sửa UserService để thao tác với database (các tác vụ tạo, sửa, xóa)

@SpringBootApplication
public class UserBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserBackendApplication.class, args);
    }

}