package techmaster.demobean;

import org.springframework.context.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoBeanApplication {

    // Tạo bean bằng cách đánh dấu annotation lên class:
    // Một số annotation phổ biến: Controller, RestController, Service, Repository, v.v
    // -> Tạo ra đối tượng duy nhất (singleton pattern) của mỗi class và đưa vào application context để quản lý
    // -> Khi muốn sử dụng 1 bean (inject bean) thì có một số cách sau:
    //      1. Dùng @Autowired
    //      2. Dùng constructor (recommended)
    //      3. Dùng setter

    // Tạo bean bằng cách đánh dấu annotation lên method:
    // @Bean : trả về 1 đối tượng
    // Class nằm ngoài @Bean phải được gắn @Configuration hoặc @SpringBootApplication
    @Bean(("student1"))
    public Student createStudent() {
        return new Student("Nguyen Trung Duc", 29);
    }

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(DemoBeanApplication.class, args);

        User user = context.getBean(User.class);
        user.hello();

        Student student1 = context.getBean("student1", Student.class);
        student1.showInfo();
        student1.showVehicle();

        Student student2 = context.getBean("student2", Student.class);
        student2.showInfo();
    }

}