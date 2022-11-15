package techmaster.demobean;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary // đánh dấu primary để ưu tiên sử dụng một bean trong trường hợp có nhiều bean cùng loại (cả bean Bus và bean Bicycle đều thuộc loại Vehicle)
public class Bus implements Vehicle {

    @Override
    public void run() {
        System.out.println("Đi học bằng xe bus");
    }

}