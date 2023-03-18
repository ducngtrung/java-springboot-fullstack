package com.example.userbackend.database;

import com.example.userbackend.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserDatabase {
    public static List<User> users = new ArrayList<>(List.of(
            new User(1, "Bùi Hiên", "buihien01091997@gmail.com", "0344005816", "Tỉnh Thái Bình", null, "111"),
            new User(2, "Nguyễn Trung Đức", "duc.nguyentrung.94@gmail.com", "0373331381", "Thành phố Hà Nội", null, "222"),
            new User(3, "Bùi Phương Loan", "hien@techmaster.vn", "0123456789", "Tỉnh Hưng Yên", null, "333")
    ));
}
