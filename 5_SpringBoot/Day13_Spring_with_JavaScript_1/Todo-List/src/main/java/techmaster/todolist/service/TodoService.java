package techmaster.todolist.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import techmaster.todolist.exception.NotFoundException;
import techmaster.todolist.model.Todo;
import techmaster.todolist.repository.TodoRepository;
import techmaster.todolist.request.CreateTodoRequest;
import techmaster.todolist.request.UpdateTodoRequest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    public List<Todo> getTodos() {
        return todoRepository.findAll();
    }

    public Todo createTodo(CreateTodoRequest request) {
        // Lấy ra id của last todo rồi cộng thêm 1 để được id mới
        int newId = getTodos().get(getTodos().size() - 1).getId() + 1;
        Todo newTodo = new Todo(
                newId,
                request.getTitle(),
                false
        );
        getTodos().add(newTodo);
        return newTodo;
    }

    public Todo updateTodoById(int id, UpdateTodoRequest request) {
        for (Todo todo : getTodos()) {
            if (todo.getId() == id) {
                todo.setTitle(request.getTitle());
                todo.setStatus(request.isStatus());
                return todo;
            }
        }
        // Nếu id không tồn tại thì throw exception
        throw new NotFoundException("ID không tồn tại");
    }

    public void deleteTodoById(int id) {
        getTodos().removeIf(todo -> todo.getId() == id);
    }

}