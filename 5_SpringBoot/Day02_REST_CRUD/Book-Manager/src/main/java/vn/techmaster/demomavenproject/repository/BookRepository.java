package vn.techmaster.demomavenproject.repository;
// repository (data access layer) là nơi tương tác trực tiếp với cơ sở dữ liệu (database)

import org.springframework.stereotype.Repository;
import vn.techmaster.demomavenproject.database.DB;
import vn.techmaster.demomavenproject.model.Book;

import java.util.List;

@Repository
public class BookRepository {
    public List<Book> getAllBooks() {
        return DB.bookList;
    }

    public Book getBookById(int id) {
        for (Book book: DB.bookList) {
            if (book.getId() == id) {
                return book;
            }
        }
        return null;
    }
}
