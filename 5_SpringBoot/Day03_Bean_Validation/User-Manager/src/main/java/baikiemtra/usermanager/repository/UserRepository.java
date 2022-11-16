package baikiemtra.usermanager.repository;

import baikiemtra.usermanager.model.User;
import com.github.javafaker.Faker;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {
    private List<User> userList;
    private final Faker faker;

    private void initUsers() {
        userList = new ArrayList<>();
        // Tạo random 40 users
        for (int i = 1; i <= 40; ++i) {
            User user = new User(
                    i,
                    faker.name().fullName(),
                    faker.internet().emailAddress(),
                    faker.phoneNumber().phoneNumber(),
                    faker.address().fullAddress(),
                    faker.avatar().image(),
                    faker.internet().password(8, 15, true, true, true)
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