package baikiemtra.usermanager.controller;

import baikiemtra.usermanager.model.User;
import baikiemtra.usermanager.request.CreateUserRequest;
import baikiemtra.usermanager.request.UpdateAvatarRequest;
import baikiemtra.usermanager.request.UpdatePasswordRequest;
import baikiemtra.usermanager.request.UpdateUserRequest;
import baikiemtra.usermanager.response.UserInfoResponse;
import baikiemtra.usermanager.response.UserListPagination;
import baikiemtra.usermanager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/")
public class UserController {

    @Autowired
    private UserService userService;

    // #0: GET : api/v1/userlist : Xem danh sách tất cả users
    @GetMapping("userlist")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    // #1 GET : api/v1/users?page={pageValue}&limit={limitValue} : Xem danh sách user có phân trang (pagination)
    // Mặc định page = 1, limit = 10
    @GetMapping("users")
    public UserListPagination getAllUsersPagination(
            @RequestParam(defaultValue = "1") String page,
            @RequestParam(defaultValue = "10") String limit
        ) {
        return userService.getAllUsersPagination(page, limit);
    }

    // #2: GET : api/v1/users/search?name={nameValue} : Xem chi tiết user theo tên
    @GetMapping("users/search")
    public UserInfoResponse getUserByName(@RequestParam String name) {
        return userService.getUserByName(name);
    }

    // #3: GET : api/v1/users/{id} : Xem chi tiết user theo id
    @GetMapping("users/{id}")
    public UserInfoResponse getUserById(@PathVariable int id) {
        return userService.getUserById(id);
    }

    // #4 POST : api/v1/users : Tạo user mới -> trả về đối tượng sau khi tạo
    @PostMapping("users")
    public UserInfoResponse createUser(@RequestBody CreateUserRequest request) {
        return userService.createUser(request);
    }

    // #5 PUT : api/v1/users/{id} : Cập nhật thông tin user -> trả về đối tượng sau khi cập nhật
    @PutMapping("users/{id}")
    public UserInfoResponse updateUserById(@PathVariable int id, @RequestBody UpdateUserRequest request) {
        return userService.updateUserById(id, request);
    }

    // #6 DELETE : api/v1/users/{id} : Xóa user
    @DeleteMapping("users/{id}")
    public void deleteUserById(@PathVariable int id) {
        userService.deleteUserById(id);
    }

    // #7 PUT : api/v1/users/{id}/update-avatar : Cập nhật ảnh avatar của user
    @PutMapping("users/{id}/update-avatar")
    public void updateAvatarById(@PathVariable int id, @RequestBody UpdateAvatarRequest request) {
        userService.updateAvatarById(id, request);
    }

    // #8 PUT : api/v1/users/{id}/update-password : Đổi mật khẩu của user
    @PutMapping("users/{id}/update-password")
    public void updatePasswordById(@PathVariable int id, @RequestBody UpdatePasswordRequest request) {
        userService.updatePasswordById(id, request);
    }

    // #9 GET : api/v1/users/{id}/forgot-password : Tạo mật khẩu mới cho user
    @GetMapping("users/{id}/forgot-password")
    public String createNewPasswordById(@PathVariable int id) {
        return userService.createNewPasswordById(id);
    }

}