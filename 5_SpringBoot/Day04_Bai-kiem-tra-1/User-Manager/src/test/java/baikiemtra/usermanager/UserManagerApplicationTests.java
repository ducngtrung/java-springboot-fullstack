package baikiemtra.usermanager;

import baikiemtra.usermanager.model.User;
import baikiemtra.usermanager.repository.UserRepository;
import baikiemtra.usermanager.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class UserManagerApplicationTests {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Test
    void showAllUsers() {
        List<User> userList = userRepository.findAll();
        for (User user : userList) {
            System.out.println(user.toString());
        }
    }

    @Test
    void createNewPasswordById() {
        System.out.println(userService.createNewPasswordById(2));
    }

    @Test
    void getAllUsersPagination() {
        System.out.println(userService.getAllUsersPagination("1", "10").toString());
    }

}