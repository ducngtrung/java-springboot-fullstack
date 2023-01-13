package com.example.jpabasic;

import com.example.jpabasic.dto.UserDto;
import com.example.jpabasic.dto.UserInfo;
import com.example.jpabasic.dto.UserMapper;
import com.example.jpabasic.entity.User;
import com.example.jpabasic.repository.UserRepository;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
public class UserTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private Faker faker;

    @Test
    void saveRandomUsers() {
        for (int i = 0; i < 30; i++) {
            User user = User.builder()
                    .name(faker.name().fullName())
                    .email(faker.internet().emailAddress())
                    .age(faker.number().numberBetween(15, 60))
                    .build();

            userRepository.save(user);
        }
    }

    // Sắp xếp theo tuổi giảm dần
    @Test
    void sortUserByAge() {
        List<User> users = userRepository.findAll(Sort.by("age").descending());
        users.forEach(System.out::println);
    }

    // Phân trang kết hợp với sắp xếp theo tuổi giảm dần
    @Test
    void paginationUser() {
        Page<User> page = userRepository.findAll(PageRequest.of(0, 10, Sort.by("age").descending()));
        page.getContent().forEach(System.out::println);
    }

    // Transaction và rollback
    @Test
    @Transactional(rollbackFor = {ArrayIndexOutOfBoundsException.class})
    void transaction_test() {
        userRepository.deleteById(154);
        try {
            throw new ArithmeticException("Có lỗi xảy ra");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    void findByEmailContainingIgnoreCase_test() {
        List<UserDto> userDtoList = userRepository.findByEmailContainingIgnoreCase("hi");
        userDtoList.forEach(System.out::println);
    }

    @Test
    void findByNameStartingWith_test() {
        List<User> users = userRepository.findByNameStartingWith("c");
        List<UserDto> userDtoList = users.stream()
                .map(user -> UserMapper.toUserDto(user))
                .toList();
        userDtoList.forEach(System.out::println);
    }

    @Test
    void findAllUserDto_test() {
        List<UserDto> userDtoList = userRepository.findAllUserDto();
        userDtoList.forEach(System.out::println);
    }

    @Test
    void findUserInfoByNameStartingWith_test() {
        List<UserInfo> userInfos = userRepository.findUserInfoByNameStartingWith("c");
        userInfos.forEach(userInfo -> System.out.println(userInfo.getId() + " - " + userInfo.getName() + " - " + userInfo.getEmail()));
    }
}
