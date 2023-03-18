package techmaster.demobean;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Component
public class Student {
    private String name;
    private int age;

    @Autowired
    private Vehicle vehicle;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void hello() {
        System.out.println("Xin chào Student");
    }

    public void showInfo() {
        System.out.println("Name: " + name + " - Age: " + age);
    }

    public void showVehicle() {
        vehicle.run();
    }
}