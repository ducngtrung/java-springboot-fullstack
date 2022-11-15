package techmaster.coursemanager.repository;

import com.github.javafaker.Faker;
import org.springframework.stereotype.Repository;
import techmaster.coursemanager.model.Course;
import techmaster.coursemanager.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Repository
public class CourseRepository {
    private List<Course> courseList;
    private final Faker faker;
    private final UserRepository userRepository;

    private void initCourses() {
        courseList = new ArrayList<>();
        Random rd = new Random();

        // Tạo sẵn list topics
        List<String> topicList = List.of("frontend", "backend", "database", "devops", "aws", "ios", "android");
        // Lấy userList từ User Repository
        List<User> userList = userRepository.findAll();

        // Tạo random 20 courses
        for (int i = 1; i <= 20; ++i) {
            // Tạo random tối đa 2 topics cho mỗi course
            List<String> rdTopics = new ArrayList<>();
            for (int j = 1; j <= 2; ++j) {
                String rdTopic = topicList.get(rd.nextInt(topicList.size()));
                if (!rdTopics.contains(rdTopic)) {
                    rdTopics.add(rdTopic);
                }
            }

            // Tạo random user quản lý cho mỗi course
            User rdUser = userList.get(rd.nextInt(userList.size()));

            // Khởi tạo course mới dựa trên thông tin random phía trên
            Course newCourse = new Course(
                    i, // id
                    faker.funnyName().name(), // name
                    faker.lorem().sentence(10), // description
                    // tạo ra số random trong khoảng (1, 2), nếu là 1 thì type "online", nếu là 2 thì type "onlab"
                    rd.nextInt(2) == 1 ? "online" : "onlab",
                    rdTopics, // topic
                    faker.avatar().image(), // ảnh thumbnail
                    rdUser.getId() // id của user quản lý
            );
            courseList.add(newCourse);
        }
    }

    private CourseRepository(Faker faker, UserRepository userRepository) {
        this.faker = faker;
        this.userRepository = userRepository;
        initCourses();
    }

    public List<Course> findAll() {
        return courseList;
    }
}
