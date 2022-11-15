package techmaster;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;
import techmaster.model.User;
import techmaster.request.LoginRequest;
import techmaster.response.UserInfoResponse;
import techmaster.service.UserService;

import java.util.List;

@SpringBootTest
class LoginFeatureApplicationTests {

    @Autowired
    private UserService userService;

    @Test
    void test_getAllUsers() {
        List<User> userList = userService.getAllUsers();
        // Kiểm tra xem userList có rỗng hay không
        assertThat(userList).isNotNull();
        // Kiểm tra xem có phải userList có 4 phần tử hay không (test này sẽ fail vì thực tế có 3 phần tử)
        assertThat(userList).hasSize(4);
    }

    @Test
    void test_login() {
        LoginRequest request = new LoginRequest("ducngtrung", "Hanoi@111");
        UserInfoResponse response = userService.login(request);
        // Kiểm tra email trả về sau khi đăng nhập
        assertThat(response.getEmail()).isEqualTo("duc.nguyentrung.94@gmail.com");
    }

}