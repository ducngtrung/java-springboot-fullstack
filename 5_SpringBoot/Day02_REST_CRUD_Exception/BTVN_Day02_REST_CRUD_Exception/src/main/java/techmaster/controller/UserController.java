package techmaster.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import techmaster.model.User;
import techmaster.request.LoginRequest;
import techmaster.response.UserInfoResponse;
import techmaster.service.UserService;

import javax.validation.Valid;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    // GET : userlist : Lấy danh sách tất cả user
    @GetMapping("userlist")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    // POST : login : Request body gồm username và password
    // Nếu username và password chính xác thì trả về thông tin của user bao gồm id, email
    // Nếu username và password không  không chính xác thì trả về message "username hoặc password chưa chính xác"
    @PostMapping("login")
    public UserInfoResponse login(@Valid @RequestBody LoginRequest request) {
        return userService.login(request);
    }

}