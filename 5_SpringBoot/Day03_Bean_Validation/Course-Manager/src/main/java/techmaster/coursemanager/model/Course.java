package techmaster.coursemanager.model;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Course {
    private int id;
    private String name;
    private String description;
    private String type; // hình thức học (chỉ có 2 hình thức online/onlab)
    private List<String> topics; // Các topic của khóa học (VD: frontend, backend, database, devops, iOS, v.v)
    private String thumbnail; // ảnh khóa học
    private int userId; // id của user quản lý khóa học
}