package techmaster.todolist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import techmaster.todolist.model.Todo;

public interface TodoRepository extends JpaRepository<Todo, Integer> {
}