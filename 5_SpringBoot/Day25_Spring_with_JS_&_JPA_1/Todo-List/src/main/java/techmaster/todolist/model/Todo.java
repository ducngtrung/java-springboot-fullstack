package techmaster.todolist.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "todo")
public class Todo {
    @Id // primary key
    @GeneratedValue // tự động generate value cho id
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    @Column(name = "title")
    private String title;

    @Column(name = "status")
    private Boolean status;

    // Vòng đời của một entity: Entity Lifecycle
    @PrePersist // Trước khi lưu vào database thì set status là false
    public void prePersist() {
        status = false;
    }
}