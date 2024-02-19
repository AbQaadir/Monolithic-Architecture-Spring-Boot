package com.example.ytpractice.job;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;




@RestController
public class JobController {
    private final JobService jobService;

    // constructor
    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    // get all jobs
    @GetMapping("/jobs")
    public List<Job> findAll() {
        return jobService.findAll();
    }

    // create a new job post mapping
    @PostMapping("/jobs")
    public String createJob(@RequestBody Job job) {
        jobService.creatJob(job);
        return job + " has been added successfully";
    }
}
