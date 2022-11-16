package baikiemtra.usermanager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Stream;

@Service
public class CourseService {

//    @Autowired
//    private CourseRepository courseRepository;
//
//    @Autowired
//    private UserService userService;
//
//    public List<Course> getAllCourses() {
//        return courseRepository.findAll();
//    }
//
//    public Stream<Course> getCoursesByFilters(String type, String topic, String name) {
//        Stream<Course> courseStream = getAllCourses().stream();
//        // lọc ra những courses mà course type giống với type variable
//        if (!type.equals("default")) {
//            courseStream = courseStream.filter(course -> course.getType().equalsIgnoreCase(type));
//        }
//        // lọc ra những courses mà trong list topics chứa topic variable
//        if (!topic.equals("default")) {
//            courseStream = courseStream.filter(course -> course.getTopics().contains(topic));
//        }
//        // lọc ra những courses mà course name chứa name variable
//        if (!name.equals("default")) {
//            courseStream = courseStream.filter(course -> course.getName().toLowerCase().
//                    contains(name.toLowerCase().subSequence(0, name.length())));
//        }
//        return courseStream;
//    }
//
//    public Map<Course, User> getCourseAndUserById(int id) {
//        Optional<Course> courseOptional = getAllCourses().stream()
//                                                .filter(course -> course.getId() == id)
//                                                .findFirst();
//
//        // Nếu courseOptional có dữ liệu thì trả về dữ liệu bên trong, nếu không có dữ liệu thì trả về null
//        Course course = courseOptional.orElse(null);
//
//        if (course != null) {
//            Map<Course, User> mapCourseUser = new HashMap<>();
//            mapCourseUser.put(course, userService.getUserById(course.getUserId()));
//            return mapCourseUser;
//        } else return null;
//    }
//
//    public Course getCourseById(int id) {
//        Optional<Course> courseOptional = getAllCourses().stream()
//                                                .filter(course -> course.getId() == id)
//                                                .findFirst();
//        return courseOptional.orElse(null);
//    }
//
//    public Course createCourse(CreateUserRequest request) {
//        Random rd = new Random();
//        int newId = rd.nextInt(100, 1000);
//
//        Course newCourse = new Course(
//                newId,
//                request.getName(),
//                request.getDescription(),
//                request.getType(),
//                request.getTopics(),
//                request.getThumbnail(),
//                request.getUserId()
//        );
//        getAllCourses().add(newCourse);
//        return newCourse;
//    }
//
//    public Course updateCourseById(int id, CreateUserRequest request) {
//        for (Course course: getAllCourses()) {
//            if (course.getId() == id) {
//                course.setName(request.getName());
//                course.setDescription(request.getDescription());
//                course.setType(request.getType());
//                course.setTopics(request.getTopics());
//                course.setThumbnail(request.getThumbnail());
//                course.setUserId(request.getUserId());
//                return course;
//            }
//        }
//        return null;
//    }
//
//    public void deleteCourseById(int id) {
//        getAllCourses().removeIf(course -> course.getId() == id);
//    }
}
