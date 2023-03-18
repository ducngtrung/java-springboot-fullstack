package techmaster.todolist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// B1: Thêm dependencies vào file pom.xml
// B2: Thêm cấu hình database vào file application.properties
// B3: Sửa model Todo thành entity Todo
// B4: Chạy ứng dụng để tạo database và table
// B5: Sửa TodoRepository để query từ database (các tác vụ tìm kiếm)
// B6: Sửa TodoService để thao tác với database (các tác vụ tạo, sửa, xóa)

@SpringBootApplication
public class TodoListApplication {

    public static void main(String[] args) {
        SpringApplication.run(TodoListApplication.class, args);
    }

}