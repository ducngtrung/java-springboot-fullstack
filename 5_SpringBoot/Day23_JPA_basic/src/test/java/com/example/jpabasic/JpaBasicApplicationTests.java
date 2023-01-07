package com.example.jpabasic;

import com.example.jpabasic.entity.User;
import com.example.jpabasic.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
class JpaBasicApplicationTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    void saveUser() {
        User user = User.builder()
                .name("Vương Khánh Huyền")
                .email("khanhhuyen712@gmail.com")
                .age(25)
                .build();

        userRepository.save(user);
    }

    @Test
    void saveMutipleUsers() {
        User user1 = User.builder()
                .name("Trần Thị Anh Đào")
                .email("trandao1970@gmail.com")
                .age(45)
                .build();

        User user2 = User.builder()
                .name("Nguyễn Xuân Hồng")
                .email("hongnx1963@vas.edu.vn")
                .age(52)
                .build();

        userRepository.saveAll(List.of(user1, user2));
    }

    @Test
    void updateUser() {
        Optional<User> userOptional = userRepository.findById(1);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            user.setName("Nguyễn Trung Đức new");
            user.setAge(29);
            userRepository.save(user);
        }
    }

    @Test
    void findByName_test() {
        List<User> users = userRepository.findByName("Vương Khánh Huyền");
        users.forEach(user -> {
            System.out.println(user.toString());
        });
    }

    @Test
    void findByNameNative_test() {
        List<User> users = userRepository.findByNameNative("Vương Khánh Huyền");
        users.forEach(user -> {
            System.out.println(user.toString());
        });
    }

    @Test
    void findByNameContainingIgnoreCase_test() {
        List<User> users = userRepository.findByNameContainingIgnoreCase("nguyễn");
        users.forEach(System.out::println);
    }

    @Test
    void existsByEmail_test() {
        System.out.println(userRepository.existsByEmail("duc.nguyentrung.94@gmail.com"));
        System.out.println(userRepository.existsByEmail("ducnguyen.bme@gmai.com"));
    }

    @Test
    void countByAgeBetweenJPQL_test() {
        System.out.println(userRepository.countByAgeBetweenJPQL(25, 50));
    }

}
