package techmaster.coursemanager;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import techmaster.coursemanager.model.Course;
import techmaster.coursemanager.model.User;
import techmaster.coursemanager.repository.UserRepository;
import techmaster.coursemanager.service.CourseService;

import java.util.List;
import java.util.stream.Stream;

@SpringBootTest
class CourseManagerApplicationTests {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CourseService courseService;

    @Test
    void showAllUsers() {
        List<User> userList = userRepository.findAll();
        for (User user : userList) {
            System.out.println(user.toString());
        }
    }

    @Test
    void showAllCourses() {
        List<Course> courseList = courseService.getAllCourses();
        for (Course course : courseList) {
            System.out.println(course.toString());
        }
    }

    @Test
    void showCoursesByFilters() {
        String type = "online";
        String topic = "devops";
        String name = "e";
        Stream<Course> courseStream = courseService.getCoursesByFilters(type, topic, name);
        System.out.println(courseStream.toList());
    }

    @Test
    void showCourseById() {
        System.out.println(courseService.getCourseById(20));
        System.out.println(courseService.getCourseById(21)); // should shown as null because there're only 20 courses
    }

    @Test
    void showCourseAndUserById() {
        System.out.println(courseService.getCourseAndUserById(20));
        System.out.println(courseService.getCourseAndUserById(21)); // should shown as null because there're only 20 courses
    }

}