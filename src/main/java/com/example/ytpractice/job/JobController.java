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
    public ResponseEntity<List<Job>> findAll() {
        return ResponseEntity.ok(jobService.findAll());
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
        if (jobService.getJobById(id) == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(jobService.getJobById(id));
        }
    }

    // Delete a job by id
    @DeleteMapping("/jobs/{id}")
    public ResponseEntity<String> deleteJob(@PathVariable long id) {
        if (jobService.getJobById(id) == null) {
            return ResponseEntity.notFound().build();
        } else {
            jobService.deleteJob(id);
            return ResponseEntity.ok("Job deleted successfully");
        }
    }

    // update a job by id by ignoring the id by user sent
    @PutMapping("/jobs/{id}")
    public ResponseEntity<String> updateJob(@PathVariable long id, @RequestBody Job job) {
        if (jobService.getJobById(id) == null) {
            return ResponseEntity.notFound().build();
        } else {
            jobService.updateJob(id, job);
            return ResponseEntity.ok("Job updated successfully");
        }
    }
}
