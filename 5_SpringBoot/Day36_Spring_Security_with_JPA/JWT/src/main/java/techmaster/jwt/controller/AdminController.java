package techmaster.jwt.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {
    @GetMapping("/admin/blogs")
    public String getAdminBlog() {
        return "blog page";
    }
}