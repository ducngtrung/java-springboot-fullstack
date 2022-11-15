package techmaster.coursemanager;

import com.github.javafaker.Faker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

//  Tạo ứng dụng Spring boot để quản lý và xem thông tin khóa học. Các chức năng bao gồm:
//    API User
//          Xem danh sách khóa học (GET /api/v1/courses?type={typeValue}&name={nameValue}&topic={topicValue}) - trong đó type hoặc name hoặc topic có thể có hoặc không
//          Xem thông tin của 1 khóa học cụ thể (thông tin bao gồm thông tin khóa học và nhân viên tư vấn) (GET /api/v1/courses/{id})
//    API Admin
//          Xem danh sách khóa học (GET /api/v1/admin/courses)
//          Tạo khóa học mới (POST /api/v1/admin/courses)
//          Lấy chi tiết khóa học (GET /api/v1/admin/courses/{id})
//          Cập nhật thông tin khóa học (PUT /api/v1/admin/courses/{id})
//          Xóa khóa học (DELETE /api/v1/admin/courses/{id})
//
//    Request gửi lên để tạo khóa học và cập nhật khóa học là UpsertCourseRequest, bao gồm:
//        name : String; // Tên khóa học
//        description : String; // Mô tả khóa học
//        type : String; // Hình thức học (chỉ có 2 hình thức online/onlab)
//        topics : List<String> // danh sách các topic của khóa học (VD : frontend, backend, database, devops, basic, mobile, ...)
//        thumbnail : String; // Ảnh khóa học
//        userId : Integer // Id người tư vấn khóa học
//
//    (Trong đó các thông tin:
//        name, type, description không được để trống
//        description có độ dài ký tự >= 50)

@SpringBootApplication
public class CourseManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(CourseManagerApplication.class, args);
    }

    @Bean
    // Tạo một database giả lập
    public Faker faker() {
        return new Faker();
    }
}
