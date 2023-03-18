package techmaster.todolist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import techmaster.todolist.model.Todo;
import techmaster.todolist.request.CreateTodoRequest;
import techmaster.todolist.request.UpdateTodoRequest;
import techmaster.todolist.service.TodoService;

import java.util.List;

@RestController
@RequestMapping("api/v1/")
public class TodoController {

    @Autowired
    private TodoService todoService;

    // 1. Lấy danh sách todos
    @GetMapping("todos")
    public List<Todo> getTodos() {
        return todoService.getTodos();
    }

    // 2. Tạo todo
    @PostMapping("todos")
    public Todo createTodo(@RequestBody CreateTodoRequest request) {
        return todoService.createTodo(request);
    }

    // 3. Cập nhật todo
    @PutMapping("todos/{id}")
    public Todo updateTodoById(@PathVariable int id, @RequestBody UpdateTodoRequest request) {
        return todoService.updateTodoById(id, request);
    }

    // 4. Xóa todo
    @DeleteMapping("todos/{id}")
    public void deleteTodoById(@PathVariable int id) {
        todoService.deleteTodoById(id);
    }

}