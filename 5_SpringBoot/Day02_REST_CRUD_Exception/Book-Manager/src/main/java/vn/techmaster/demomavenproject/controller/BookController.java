package vn.techmaster.demomavenproject.controller;
// controller (presentation layer) là nơi định nghĩa các API request

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vn.techmaster.demomavenproject.model.Book;
import vn.techmaster.demomavenproject.request.UpsertBookRequest;
import vn.techmaster.demomavenproject.service.BookService;

import java.util.List;

@RestController
@RequestMapping("api/v1/")
public class BookController {

    @Autowired // inject bean
    private BookService bookService;

    // GET : api/v1/books : Lấy danh sách tất cả cuốn sách
    @GetMapping("books")
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    // POST : api/v1/books : Tạo mới 1 cuốn sách -> trả về đối tượng sau khi tạo
    @PostMapping("books")
    public Book createBook(@RequestBody UpsertBookRequest request) {
        return bookService.createBook(request);
    }

    // GET : api/v1/books/{id} : Lấy chi tiết 1 cuốn sách -> -> trả về đối tượng được lấy ra
    @GetMapping("books/{id}")
    public Book getBookById(@PathVariable int id) {
        return bookService.getBookById(id);
    }

    // PUT : api/v1/books/{id} : Cập nhật thông tin 1 cuốn sách -> trả về đối tượng sau khi cập nhật
    @PutMapping("books/{id}")
    public Book updateBookById(@PathVariable int id, @RequestBody UpsertBookRequest request) {
        return bookService.updateBookById(id, request);
    }

    // DELETE : api/v1/books/{id} : Xóa sách theo id
    @DeleteMapping("books/{id}")
    public void deleteBookById(@PathVariable int id) {
        bookService.deleteBookById(id);
    }

}