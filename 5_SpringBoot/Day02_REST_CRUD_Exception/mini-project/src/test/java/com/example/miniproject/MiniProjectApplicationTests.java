package com.example.miniproject;

import com.example.miniproject.service.ColorService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class MiniProjectApplicationTests {

    @Autowired
    private ColorService colorService;

    @Test
    void test_randomRgbColor() {
        String rs = colorService.randomRgbColor();

        assertThat(rs).isNotNull();
        assertThat(rs).startsWith("rgb");
//        assertThat(rs).isEqualTo("rgb(11,23,124)");
    }

}
