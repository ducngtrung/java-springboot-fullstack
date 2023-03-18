package techmaster.coursemanager.repository;

import com.github.javafaker.Faker;
import org.springframework.stereotype.Repository;
import techmaster.coursemanager.model.User;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {
    private List<User> userList;
    private final Faker faker;

    private void initUsers() {
        userList = new ArrayList<>();
        // Tạo random users
        for (int i = 1; i <= 5; ++i) {
            User user = new User(
                    i,
                    faker.name().fullName(),
                    faker.internet().emailAddress(),
                    faker.phoneNumber().phoneNumber(),
                    faker.avatar().image()
            );
            userList.add(user);
        }
    }

    private UserRepository(Faker faker) {
        this.faker = faker;
        initUsers();
    }

    public List<User> findAll() {
        return userList;
    }
}