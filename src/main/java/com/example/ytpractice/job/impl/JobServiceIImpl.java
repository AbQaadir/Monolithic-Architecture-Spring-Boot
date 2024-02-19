package com.example.ytpractice.job.impl;

import com.example.ytpractice.job.Job;
import com.example.ytpractice.job.JobRepository;
import com.example.ytpractice.job.JobService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobServiceIImpl implements JobService {
//    private List<Job> jobs = new ArrayList<>();

    JobRepository jobRepository;

    public JobServiceIImpl(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }
    private long nextId;

    @Override
    public List<Job> findAll() {
        return jobRepository.findAll();
    }

    @Override
    public void creatJob(Job job) {
        job.setId(++nextId);
        jobRepository.save(job);
    }

    @Override
    public Job getJobById(long id) {
        return jobRepository.findById(id).orElse(null);
    }

    @Override
    public boolean deleteJob(long id) {
        try {
            jobRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }


    @Override
    public boolean updateJob(long id, Job updatedJob){
        Optional<Job> jobOptional = jobRepository.findById(id);

        if (jobOptional.isPresent()){
            Job job = jobOptional.get();

            job.setTitle(updatedJob.getTitle());
            job.setDescription(updatedJob.getDescription());
            job.setMinSalary(updatedJob.getMinSalary());
            job.setMaxSalary(updatedJob.getMaxSalary());
            job.setLocation(updatedJob.getLocation());
            job.setPostedDate(updatedJob.getPostedDate());

            jobRepository.save(job);

            return true;
        }

        return false;
    }
}
