package com.example.ytpractice.job;

import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Job> getJobById(@PathVariable long id) {
        if(jobService.getJobById(id) == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(jobService.getJobById(id));
        }
    }
}
