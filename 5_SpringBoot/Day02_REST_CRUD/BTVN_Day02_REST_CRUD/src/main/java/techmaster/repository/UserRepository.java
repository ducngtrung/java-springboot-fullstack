package techmaster.repository;

import org.springframework.stereotype.Repository;
import techmaster.database.DB;
import techmaster.model.User;
import techmaster.request.LoginRequest;

import java.util.List;

@Repository
public class UserRepository {

    public List<User> findAll() {
        return DB.userList;
    }

    public User findUserByLoginRequest(LoginRequest request) {
        for (User user : DB.userList) {
            if (user.getUsername().equals(request.getUsername()) &&
                user.getPassword().equals(request.getPassword())) {
                return user;
            }
        }
        return null;
    }
}