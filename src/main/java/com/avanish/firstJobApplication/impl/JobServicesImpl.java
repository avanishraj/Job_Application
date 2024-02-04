package com.avanish.firstJobApplication.impl;

import com.avanish.firstJobApplication.controllers.JobServices;
import com.avanish.firstJobApplication.controllers.Jobs;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class JobServicesImpl implements JobServices {
    private final List<Jobs> jobs = new ArrayList<>();
    private Long nextId = 1L;
    @Override
    public void createJob(Jobs job) {
        job.setId(nextId++);
        jobs.add(job);
    }

    @Override
    public List<Jobs> findAll() {
        return jobs;
    }

    @Override
    public Jobs findJobById(Long id) {
        for (Jobs job: jobs){
            if (job.getId().equals(id)){
                return job;
            }
        }
        return null;
    }

    @Override
    public void deleteById(Long id) {
//        for(Jobs job: jobs){
//            if(job.getId().equals(id)){
//                jobs.remove(job);
//            }
//        }
        // or

        jobs.removeIf(job -> job.getId().equals(id));
    }

    @Override
    public boolean updateJobById(Long id, Jobs updatedBody) {
        for (Jobs job : jobs){
            if (job.getId().equals(id)){
                job.setTitle(updatedBody.getTitle());
                job.setDescription(updatedBody.getDescription());
                job.setLocation(updatedBody.getLocation());
                job.setMaxSalary(updatedBody.getMaxSalary());
                job.setMinSalary(updatedBody.getMinSalary());
                return true;
            }
        }
        return false;
    }
}
