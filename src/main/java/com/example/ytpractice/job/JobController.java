package com.example.ytpractice.job;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;


@RestController
public class JobController {
    private List<Job> jobs = new ArrayList<>();

    // get all jobs
    @GetMapping("/jobs")
    public List<Job> findAll() {
        return jobs;
    }

    // get job by id
    @GetMapping("/jobs/{id}")
    public Job findById(long id) {
        for (Job job : jobs) {
            if (job.getId() == id) {
                return job;
            }
        }
        return null;
    }


    // create a new job post mapping
    @PostMapping("/jobs")
    public String createJob(@RequestBody Job job) {
        jobs.add(job);
        return job + " has been added successfully";
    }
}
