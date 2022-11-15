package techmaster;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//1. Hãy định nghĩa một class User gồm các trường:
//
//        id : Kiểu int
//        username : Kiểu String
//        email : Kiểu String
//        password : Kiểu String
//        avatar : kiểu String
//
//        Với các phương thức như : setter, getter, constructor, … sử dụng Lombok để thực hiện
//
//2. Trong ứng dụng Spring Boot tạo API thực hiện chức năng sau:
//
//   POST http://localhost:8080/login
//   Reqest Body có cấu trúc như sau:
//    {
//        "username" : username
//        "password" : password
//    }
//
//   Kết quả trả về:
//   Nếu username và password chính xác : Trả về thông tin của user bao gồm username, email, avatar
//   Nếu username và password không chính xác : Trả về username hoặc password chưa chính xác

@SpringBootApplication
public class LoginFeatureApplication {

    public static void main(String[] args) {
        SpringApplication.run(LoginFeatureApplication.class, args);
    }

}