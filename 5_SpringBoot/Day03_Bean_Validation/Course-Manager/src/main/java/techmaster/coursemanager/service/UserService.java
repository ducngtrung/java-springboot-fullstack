package techmaster.coursemanager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import techmaster.coursemanager.model.Course;
import techmaster.coursemanager.model.User;
import techmaster.coursemanager.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(int id) {
        return getAllUsers().stream()
                .filter(user -> user.getId() == id)
                .findFirst()
                .get();
    }
}
