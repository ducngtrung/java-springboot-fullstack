package techmaster.coursemanager.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UpsertCourseRequest {
    @NotBlank(message = "name is required")
    private String name;

    @NotBlank(message = "description is required")
    @Size(min = 50, message = "description must have at least 50 characters")
    private String description;

    @NotBlank(message = "type is required")
    private String type;

    private List<String> topics; // Các topic của khóa học (VD: frontend, backend, database, devops, iOS, v.v)
    private String thumbnail; // ảnh khóa học
    private int userId; // id của user quản lý khóa học
}
