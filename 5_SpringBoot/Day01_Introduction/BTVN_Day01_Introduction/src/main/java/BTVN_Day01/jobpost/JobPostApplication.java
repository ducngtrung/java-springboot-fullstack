package BTVN_Day01.jobpost;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//  Hãy định nghĩa một class Job gồm các trường:
//
//        id : kiểu String, mã tin tuyển dụng cần phải là duy nhất (unique)
//        title: kiểu String, tiêu đề tuyển dụng
//        description: kiểu String, mô tả tin tuyển dụng
//        location: kiểu String, địa chỉ tuyển dụng
//        minSalary: int, lương tối thiểu
//        maxSalary: int, lương tối đa
//        emailTo: String, email nhà tuyển dụng
//
//  Yêu cầu tạo REST API CRUD giống như bài book đã thực hành trên lớp:
//      GET http://localhost:8080/api/v1/jobs/random : trả về một job ngẫu nhiên trong danh sách
//      GET http://localhost:8080/api/v1/sort?max_salary=desc : trả về danh sách job được sắp xếp giảm dần theo lương tối đa (gợi ý sử dụng @RequestParam)

@SpringBootApplication
public class JobPostApplication {

    public static void main(String[] args) {
        SpringApplication.run(JobPostApplication.class, args);
    }

}