package com.example.ytpractice.job.impl;

import com.example.ytpractice.job.Job;
import com.example.ytpractice.job.JobService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JobServiceIImpl implements JobService {
    private List<Job> jobs = new ArrayList<>();

    private long nextId;
    @Override
    public List<Job> findAll() {
        return jobs;
    }

    @Override
    public void creatJob(Job job) {
        job.setId(++nextId);
        jobs.add(job);
    }
}
