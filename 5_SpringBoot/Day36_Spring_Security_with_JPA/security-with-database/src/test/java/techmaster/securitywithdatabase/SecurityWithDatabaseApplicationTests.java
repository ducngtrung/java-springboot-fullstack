package techmaster.securitywithdatabase;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import techmaster.securitywithdatabase.entity.User;
import techmaster.securitywithdatabase.repository.UserRepository;

@SpringBootTest
class SecurityWithDatabaseApplicationTests {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    // Tạo chuỗi password mã hóa bằng BCryptPasswordEncoder từ chuỗi password raw
    @Test
    void test_encode() {
        System.out.println(passwordEncoder.encode("111"));
    }

    @Test
    void save_user() {
        User user1 = User.builder()
                .name("duc")
                .email("ducnguyen.bme@gmail.com")
                .password(passwordEncoder.encode("111"))
                .role("ADMIN")
                .build();

        User user2 = User.builder()
                .name("huyen")
                .email("khanhhuyen712@gmail.com")
                .password(passwordEncoder.encode("111"))
                .role("USER")
                .build();

        userRepository.save(user1);
        userRepository.save(user2);
    }

}