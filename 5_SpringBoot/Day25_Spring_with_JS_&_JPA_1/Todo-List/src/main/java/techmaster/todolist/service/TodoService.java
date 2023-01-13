package techmaster.todolist.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import techmaster.todolist.exception.BadRequestException;
import techmaster.todolist.exception.NotFoundException;
import techmaster.todolist.model.Todo;
import techmaster.todolist.repository.TodoRepository;
import techmaster.todolist.request.CreateTodoRequest;
import techmaster.todolist.request.UpdateTodoRequest;

import java.util.List;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    public List<Todo> getTodos() {
        // sử dụng phương thức findAll có sẵn trong JPA
        return todoRepository.findAll();
    }

    public Todo createTodo(CreateTodoRequest request) {
        // Nếu tiêu đề trống thì throw BadRequestException
        if (request.getTitle().trim().length() == 0) {
            throw new BadRequestException("Tiêu đề không được để trống");
        }

        // Nếu tiêu đề có dữ liệu thì tạo todo mới rồi set title mới cho nó
        Todo todo = new Todo();
        todo.setTitle(request.getTitle());
        // todo.setStatus(false);
        // Không cần set status mặc định là false nữa vì đã cấu hình trong annotation @PrePersist ở entity Todo

        // Lưu todo mới vào database
        return todoRepository.save(todo);
    }

    public Todo updateTodoById(int id, UpdateTodoRequest request) {
        // Nếu id không tồn tại thì throw NotFoundException
        Todo todo = todoRepository.findById(id).orElseThrow(() -> {
            throw new NotFoundException("Không tồn tại todo có id = " + id);
        });

        // Nếu tiêu đề trống thì throw BadRequestException
        if (request.getTitle().trim().length() == 0) {
            throw new BadRequestException("Tiêu đề không được để trống");
        }

        // Nếu id tồn tại và tiêu đề có dữ liệu thì cập nhật todo với title mới và status mới
        todo.setTitle(request.getTitle());
        todo.setStatus(request.isStatus());

        // Lưu todo vừa cập nhật vào database
        return todoRepository.save(todo);
    }

    public void deleteTodoById(int id) {
        // Nếu id không tồn tại thì throw NotFoundException
        Todo todo = todoRepository.findById(id).orElseThrow(() -> {
            throw new NotFoundException("Không tồn tại todo có id = " + id);
        });

        todoRepository.delete(todo);
    }

}