package com.example.ytpractice.job;

import org.springframework.web.bind.annotation.*;

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

    // get a job by id
    @GetMapping("/jobs/{id}")
    public Job getJobById(@PathVariable long id) {
        return jobService.getJobById(id);
    }
}
