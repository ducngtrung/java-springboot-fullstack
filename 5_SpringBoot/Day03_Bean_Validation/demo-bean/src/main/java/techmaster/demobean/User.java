package techmaster.demobean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Component
public class User {
    private String name;
    private int age;

    public void hello() {
        System.out.println("Xin chào User");
    }
}