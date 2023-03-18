package vn.techmaster.demomavenproject.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebController {
    // GET : api/helloworld
    @GetMapping("api/helloworld")
    public String getHello() {
        return "Hello World";
    }
}