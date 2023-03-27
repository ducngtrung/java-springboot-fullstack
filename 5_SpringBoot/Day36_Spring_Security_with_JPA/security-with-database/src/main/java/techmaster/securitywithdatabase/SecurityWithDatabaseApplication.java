// Bài tập này lấy thông tin user được lưu trong database để check authentication

package techmaster.securitywithdatabase;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SecurityWithDatabaseApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecurityWithDatabaseApplication.class, args);
    }

}