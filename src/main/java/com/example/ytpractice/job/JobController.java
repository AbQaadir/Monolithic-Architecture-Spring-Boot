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
    public ResponseEntity<Job> findAll() {
        List<Job> jobs = jobService.findAll();
        if (jobs.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok((Job) jobs);
        }
    }

    // create a new job post mapping
    @PostMapping("/jobs")
    public ResponseEntity<String> createJob(@RequestBody Job job) {
        jobService.creatJob(job);
        return ResponseEntity.ok("Job created successfully");
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
