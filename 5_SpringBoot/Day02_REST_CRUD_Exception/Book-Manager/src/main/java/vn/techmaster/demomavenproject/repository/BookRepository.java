package vn.techmaster.demomavenproject.repository;
// repository (data access layer) là nơi tương tác trực tiếp với cơ sở dữ liệu (database)

import org.springframework.stereotype.Repository;
import vn.techmaster.demomavenproject.database.DB;
import vn.techmaster.demomavenproject.model.Book;

import java.util.List;
import java.util.Optional;

@Repository
public class BookRepository {
    public List<Book> findAll() {
        return DB.bookList;
    }

    public Optional<Book> findById(int id) { // Dùng Option vì dữ liệu trả về có thể null (nếu id cần tìm không tồn tại)
        return DB.bookList
                .stream()
                .filter(book -> book.getId() == id)
                .findFirst();
    }
}
