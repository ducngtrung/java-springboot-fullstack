package techmaster.securitybasic.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebController {
    @GetMapping("/")
    public String getHomePage() {
        return "home page";
    }
}