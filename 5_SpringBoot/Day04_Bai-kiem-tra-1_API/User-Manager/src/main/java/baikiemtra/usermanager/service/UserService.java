package baikiemtra.usermanager.service;

import baikiemtra.usermanager.exception.BadRequestException;
import baikiemtra.usermanager.exception.NotFoundException;
import baikiemtra.usermanager.model.User;
import baikiemtra.usermanager.repository.UserRepository;
import baikiemtra.usermanager.request.CreateUserRequest;
import baikiemtra.usermanager.request.UpdateAvatarRequest;
import baikiemtra.usermanager.request.UpdatePasswordRequest;
import baikiemtra.usermanager.request.UpdateUserRequest;
import baikiemtra.usermanager.response.UserInfoResponse;
import baikiemtra.usermanager.response.UserListPagination;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    private final Faker faker;

    private UserService(Faker faker) {
        this.faker = faker;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public UserInfoResponse userInfoResponse(User user) {
        return new UserInfoResponse(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getPhone(),
                user.getAddress(),
                user.getAvatar()
        );
    }

    public UserListPagination getAllUsersPagination(String page, String limit) {
        int pageNum = Integer.parseInt(page);
        int limitNum = Integer.parseInt(limit);

        int size = getAllUsers().size();
        int totalPage = 0;
        if (size%limitNum == 0) {
            totalPage = size/limitNum;
        } else totalPage = size/limitNum + 1;

        int beginIndex = (pageNum-1)*limitNum;
        int endIndex = beginIndex + limitNum - 1;
        if (endIndex > (size-1)) {
            endIndex = size-1;
        }

        List<UserInfoResponse> userInfoResponseList = new ArrayList<>();
        for (int i = beginIndex; i <= endIndex; ++i) {
            userInfoResponseList.add(userInfoResponse(getAllUsers().get(i)));
        }
        return new UserListPagination(userInfoResponseList, pageNum, size, totalPage);
    }

    public UserInfoResponse getUserById(int id) {
        for (User user : getAllUsers()) {
            if (user.getId() == id) {
                return userInfoResponse(user);
            }
        }
        return null;
    }

    public UserInfoResponse getUserByName(String name) {
        for (User user : getAllUsers()) {
            if (user.getName().toLowerCase().contains(name.toLowerCase().subSequence(0, name.length()))) {
                return userInfoResponse(user);
            }
        }
        return null;
    }

    public UserInfoResponse createUser(CreateUserRequest request) {
        List<Integer> idList = new ArrayList<>();
        for (User user : getAllUsers()) {
            idList.add(user.getId());
        }

        int newId = 0;
        Random rd = new Random();
        do {
            newId = rd.nextInt(50, 1000);
        } while (idList.contains(newId));

        User newUser = new User(
                newId,
                request.getName(),
                request.getEmail(),
                request.getPhone(),
                request.getAddress(),
                null,
                request.getPassword()
        );
        getAllUsers().add(newUser);
        return userInfoResponse(newUser);
    }

    public UserInfoResponse updateUserById(int id, UpdateUserRequest request) {
        for (User user : getAllUsers()) {
            if (user.getId() == id) {
                user.setName(request.getName());
                user.setPhone(request.getPhone());
                user.setAddress(request.getAddress());
                return userInfoResponse(user);
            }
        }
        return null;
    }

    public void deleteUserById(int id) {
        getAllUsers().removeIf(user -> user.getId() == id);
    }

    public void updateAvatarById(int id, UpdateAvatarRequest request) {
        for (User user : getAllUsers()) {
            if (user.getId() == id) {
                user.setAvatar(request.getAvatar());
                break;
            }
        }
    }

    public void updatePasswordById(int id, UpdatePasswordRequest request) {
        for (User user : getAllUsers()) {
            if (user.getId() == id) {
                if (!user.getPassword().equals(request.getOldPassword())) {
                    throw new BadRequestException("mật khẩu cũ chưa chính xác");
                } else if (request.getNewPassword().equals(request.getOldPassword())) {
                    throw new BadRequestException("mật khẩu mới trùng với mật khẩu cũ");
                } else {
                    user.setPassword(request.getNewPassword());
                }
                return;
            }
        }
        throw new NotFoundException("không tìm thấy user");
    }

    public String createNewPasswordById(int id) {
        for (User user : getAllUsers()) {
            if (user.getId() == id) {
                String newPassword = faker.internet().password(8, 15, true, true, true);
                user.setPassword(newPassword);
                return "new password: " + newPassword;
            }
        }
        throw new NotFoundException("không tìm thấy user");
    }

}