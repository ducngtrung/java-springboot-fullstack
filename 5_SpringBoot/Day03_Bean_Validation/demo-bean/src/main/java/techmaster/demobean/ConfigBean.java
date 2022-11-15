package techmaster.demobean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigBean {
    @Bean(("student2"))
    public Student createStudent() {
        return new Student("Vuong Khanh Huyen", 27);
    }
}
