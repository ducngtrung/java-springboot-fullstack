package techmaster.demobean;

import org.springframework.stereotype.Component;

@Component
public class Bicycle implements Vehicle {

    @Override
    public void run() {
        System.out.println("Đi học bằng xe đạp");
    }

}