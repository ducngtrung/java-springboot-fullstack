package vn.techmaster.demomavenproject.service;
// service là nơi chứa các method xử lý logic để trả về kết quả (API response)

import org.springframework.stereotype.Service;
import vn.techmaster.demomavenproject.model.Book;
import vn.techmaster.demomavenproject.request.UpsertBookRequest;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class BookService {
    private List<Book> bookList;

    public BookService() {
        bookList = new ArrayList<>();
        bookList.add(new Book(1, "De Men Phieu Luu Ky", 2020));
        bookList.add(new Book(2, "Toi Thay Hoa Vang Tren Co Xanh", 2021));
        bookList.add(new Book(3, "Mat Biec", 2018));
    }

    public List<Book> getAllBooks() {
        return bookList;
    }

    public Book getBookById(int id) {
        for (Book book: bookList) {
            if (book.getId() == id) {
                return book;
            }
        }
        return null;
    }

    public Book createBook(UpsertBookRequest request) {
        Random rd = new Random();
        int id = rd.nextInt(1000);

        Book newBook = new Book(
                id,
                request.getTitle(),
                request.getPublishYear()
        );
        bookList.add(newBook);
        return newBook;
    }

    public Book updateBookById(int id, UpsertBookRequest request) {
        for (Book book: bookList) {
            if (book.getId() == id) {
                book.setTitle(request.getTitle());
                book.setPublishYear(request.getPublishYear());
                return book;
            }
        }
        return null;
    }

    public void deleteBookById(int id) {
        bookList.removeIf(book -> book.getId() == id);
    }
}