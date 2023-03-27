package techmaster.securitybasic2;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
class SecurityBasic2ApplicationTests {
    @Autowired
    private PasswordEncoder passwordEncoder;

    // Tạo chuỗi password mã hóa bằng BCryptPasswordEncoder từ chuỗi password raw
    @Test
    void test_encode() {
        System.out.println(passwordEncoder.encode("111"));
    }

}