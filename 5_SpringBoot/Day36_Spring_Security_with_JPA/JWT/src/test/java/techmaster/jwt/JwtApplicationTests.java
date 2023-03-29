package techmaster.jwt;

import io.jsonwebtoken.Claims;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import techmaster.jwt.entity.User;
import techmaster.jwt.repository.UserRepository;
import techmaster.jwt.security.JwtTokenUtil;

import java.util.Optional;

@SpringBootTest
class JwtApplicationTests {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

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

    @Test
    void generate_token_test() {
        Optional<User> userOptional = userRepository.findByEmail("ducnguyen.bme@gmail.com");
        if(userOptional.isPresent()) {
            String token = jwtTokenUtil.generateToken(userOptional.get());
            System.out.println(token);
        }
    }

    @Test
    void parse_token_test() {
        // Dùng token được tạo bởi generate_token_test() làm tham số đầu vào
        String token = "eyJhbGciOiJIUzM4NCJ9.eyJhdXRob3JpdGllcyI6W3siYXV0aG9yaXR5IjoiUk9MRV9BRE1JTiJ9XSwic3ViIjoiZHVjbmd1eWVuLmJtZUBnbWFpbC5jb20iLCJpYXQiOjE2ODAwODEyODQsImV4cCI6MTY4MDE2NzY4NH0.R5DiZw06dcqxb8N0o4qvEvFG0huhH5v-C0F4x0JGNeT6Gu9ei8lHloSevSflP4yF";
        Claims claims = jwtTokenUtil.getClaimsFromToken(token);
        System.out.println(claims.getSubject());
    }

}