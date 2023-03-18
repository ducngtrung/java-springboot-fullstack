package vn.techmaster.demomavenproject.database;

import vn.techmaster.demomavenproject.model.Book;

import java.util.ArrayList;
import java.util.List;

public class DB {
    // Tạo biến static để khi gọi bookList có thể gọi trực tiếp từ class DB mà không cần gọi qua đối tượng
    public static List<Book> bookList = new ArrayList<>(List.of(
            new Book(1, "De Men Phieu Luu Ky", 2020),
            new Book(2, "Toi Thay Hoa Vang Tren Co Xanh", 2021),
            new Book(3, "Mat Biec", 2018)
    ));
}