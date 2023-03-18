package techmaster.coursemanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import techmaster.coursemanager.model.Course;
import techmaster.coursemanager.model.User;
import techmaster.coursemanager.request.UpsertCourseRequest;
import techmaster.coursemanager.service.CourseService;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/")
public class CourseController {

    @Autowired
    private CourseService courseService;

    // GET : api/v1/courses?type={typeValue}&topic={topicValue}&name={nameValue} : Xem danh sách khóa học sau khi lọc
    // Trong đó type hoặc topic hoặc name có thể có hoặc không
    // Nếu nameValue có dấu cách thì trên URL phải đổi dấu cách thành '%20'
    @GetMapping("courses")
    public List<Course> getCoursesByFilters(
            @RequestParam(defaultValue = "default") String type,
            @RequestParam(defaultValue = "default") String topic,
            @RequestParam(defaultValue = "default") String name
        ) {
        return courseService.getCoursesByFilters(type, topic, name).toList();
    }

    // GET : api/v1/courses/{id} : Xem chi tiết 1 khóa học và user quản lý tương ứng
    @GetMapping("courses/{id}")
    public Map<Course, User> getCourseAndUserById(@PathVariable int id) {
        return courseService.getCourseAndUserById(id);
    }

    // GET : api/v1/admin/courses : Xem danh sách khóa học
    @GetMapping("admin/courses")
    public List<Course> getAllCourses() {
        return courseService.getAllCourses();
    }

    // GET : api/v1/admin/courses/{id} : Xem chi tiết 1 khóa học
    @GetMapping("admin/courses/{id}")
    public Course getCourseById(@PathVariable int id) {
        return courseService.getCourseById(id);
    }

    // POST : api/v1/admin/courses : Tạo khóa học mới -> trả về đối tượng sau khi tạo
    @PostMapping("admin/courses")
    public Course createCourse(@Valid @RequestBody UpsertCourseRequest request) {
        return courseService.createCourse(request);
    }

    // PUT : api/v1/admin/courses/{id} : Cập nhật thông tin khóa học -> trả về đối tượng sau khi cập nhật
    @PutMapping("admin/courses/{id}")
    public Course updateCourseById(@PathVariable int id, @Valid @RequestBody UpsertCourseRequest request) {
        return courseService.updateCourseById(id, request);
    }

    // DELETE : api/v1/admin/courses/{id} : Xóa khóa học
    @DeleteMapping("admin/courses/{id}")
    public void deleteCourseById(@PathVariable int id) {
        courseService.deleteCourseById(id);
    }
}