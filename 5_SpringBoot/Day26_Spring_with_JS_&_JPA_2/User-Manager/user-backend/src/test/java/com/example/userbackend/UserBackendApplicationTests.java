package com.example.userbackend;

import com.example.userbackend.model.User;
import com.example.userbackend.model.dto.UserDto;
import com.example.userbackend.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.util.ArrayList;
import java.util.List;

@DataJpaTest // chuyên dùng để test repository
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class UserBackendApplicationTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    @Rollback(value = false) // nếu không có value = false thì app sẽ rollback mọi thay đổi sau khi chạy test xong
    void init_users() {
        List<User> initUsers = new ArrayList<>(List.of(
                new User(1, "Bùi Hiên", "buihien01091997@gmail.com", "0344005816", "Tỉnh Thái Bình", null, "111"),
                new User(2, "Nguyễn Trung Đức", "duc.nguyentrung.94@gmail.com", "0373331381", "Thành phố Hà Nội", null, "222"),
                new User(3, "Bùi Phương Loan", "hien@techmaster.vn", "0123456789", "Tỉnh Hưng Yên", null, "333")
        ));

        userRepository.saveAll(initUsers);
    }

    @Test
    void get_all_user_dto() {
        List<UserDto> userDtoList = userRepository.findAllUserDto();
        userDtoList.forEach(System.out::println);
    }

}