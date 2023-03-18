package techmaster.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import techmaster.exception.NotFoundException;
import techmaster.model.User;
import techmaster.repository.UserRepository;
import techmaster.request.LoginRequest;
import techmaster.response.UserInfoResponse;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public UserInfoResponse login(LoginRequest request) {
        User userResult = userRepository.findUserByLoginRequest(request);
        if (userResult != null) {
            return new UserInfoResponse(userResult.getId(), userResult.getEmail());
        } else {
            throw new NotFoundException("username hoặc password chưa chính xác");
        }
    }

}