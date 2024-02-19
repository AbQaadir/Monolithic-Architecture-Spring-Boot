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

    @Override
    public Job getJobById(long id) {
        for (Job job : jobs) {
            if (job.getId() == id) {
                return job;
            }
        }
        return null;
    }

    @Override
    public void deleteJob(long id) {
        jobs.removeIf(job -> job.getId() == id);
    }


    @Override
    public boolean updateJob(long id, Job updatedJob){
        for (Job job : jobs) {
            if (job.getId() == id) {
                job.setTitle(updatedJob.getTitle());
                job.setDescription(updatedJob.getDescription());
                job.setMinSalary(updatedJob.getMinSalary());
                job.setMaxSalary(updatedJob.getMaxSalary());
                job.setLocation(updatedJob.getLocation());
                job.setPostedDate(updatedJob.getPostedDate());
                return true;
            }
        }
        return false;
    }
}
