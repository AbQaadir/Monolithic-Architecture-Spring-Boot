package com.example.ytpractice.job;

import java.util.List;

public interface JobService {
    List<Job> findAll();
    void creatJob(Job job);

    Job getJobById(long id);

    void deleteJob(long id);

    boolean updateJob(long id, Job updatedJob);
}
