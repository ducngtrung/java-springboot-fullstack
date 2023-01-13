package com.example.jpabasic.dto;

import com.example.jpabasic.entity.User;

public class UserMapper {
    // Phương thức này để khởi tạo 1 đối tượng UserDto từ User
    public static UserDto toUserDto(User user) {
        return new UserDto(user.getId(), user.getName(), user.getEmail());
    }
}