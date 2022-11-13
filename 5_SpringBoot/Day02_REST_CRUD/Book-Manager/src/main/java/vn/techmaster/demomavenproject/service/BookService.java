package vn.techmaster.demomavenproject.service;
// service (business layer) là nơi chứa các method xử lý logic để trả về kết quả (API response)

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.techmaster.demomavenproject.model.Book;
import vn.techmaster.demomavenproject.repository.BookRepository;
import vn.techmaster.demomavenproject.request.UpsertBookRequest;

import java.util.List;
import java.util.Random;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAllBooks() {
        return bookRepository.getAllBooks();
    }

    public Book getBookById(int id) {
//        for (Book book: bookList) {
//            if (book.getId() == id) {
//                return book;
//            }
//        }
        return null;
    }

    public Book createBook(UpsertBookRequest request) {
//        Random rd = new Random();
//        int id = rd.nextInt(1000);
//
//        Book newBook = new Book(
//                id,
//                request.getTitle(),
//                request.getPublishYear()
//        );
//        bookList.add(newBook);
//        return newBook;
        return  null;
    }

    public Book updateBookById(int id, UpsertBookRequest request) {
//        for (Book book: bookList) {
//            if (book.getId() == id) {
//                book.setTitle(request.getTitle());
//                book.setPublishYear(request.getPublishYear());
//                return book;
//            }
//        }
        return null;
    }

    public void deleteBookById(int id) {
//        bookList.removeIf(book -> book.getId() == id);
    }
}