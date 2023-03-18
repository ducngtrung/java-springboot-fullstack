package BTVN_Day01.jobpost.controller;

import BTVN_Day01.jobpost.model.Job;
import BTVN_Day01.jobpost.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/")
public class JobController {

    @Autowired
    private JobService jobService;

    // GET api/v1/jobs/random : trả về một job ngẫu nhiên trong danh sách
    @GetMapping("jobs/random")
    public Job getRandomJob() {
        return jobService.getRandomJob();
    }

    // GET api/v1/jobs/sort?max_salary=desc : trả về danh sách job được sắp xếp giảm dần hoặc tăng dần theo lương tối đa (yêu cầu sử dụng @RequestParam để lấy thứ tự sắp xếp ("desc" hoặc "asc") từ request query)
    @GetMapping("jobs/sort")
    public List<Job> sortJobsByMaxSalary(@RequestParam String max_salary) {
        return jobService.sortJobsByMaxSalary(max_salary);
    }

}