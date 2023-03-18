package techmaster.database;

import techmaster.model.User;

import java.util.ArrayList;
import java.util.List;

public class DB {
    public static List<User> userList = new ArrayList<>(List.of(
            new User(1, "ducngtrung", "Hanoi@123", "duc.nguyentrung.94@gmail.com"),
            new User(2, "huyenkhanh", "khanhhuyen712", "khanhhuyen1296@gmail.com"),
            new User(3, "hungvu94", "hungvu@123", "hung.vuquang@gmail.com")
    ));
}
