package com.avanish.firstJobApplication.job;

import com.avanish.firstJobApplication.job.JobServices;
import com.avanish.firstJobApplication.job.Jobs;
import com.avanish.firstJobApplication.job.JobRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobServicesImpl implements JobServices {
    JobRepository jobRepository;
    public JobServicesImpl(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    //    private final List<Jobs> jobs = new ArrayList<>();
//    private Long nextId = 1L;
    @Override
    public void createJob(Jobs job) {
//        job.setId(nextId++);
        jobRepository.save(job);
    }

    @Override
    public List<Jobs> findAll() {
        return jobRepository.findAll();
    }

    @Override
    public Jobs findJobById(Long id) {
        return jobRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Long id) {
//        for(Jobs job: jobs){
//            if(job.getId().equals(id)){
//                jobs.remove(job);
//            }
//        }
        // or

//        jobs.removeIf(job -> job.getId().equals(id));
        try {
            jobRepository.deleteById(id);
        }catch (Exception e){
            jobRepository.notify();
        }
    }

    @Override
    public boolean updateJobById(Long id, Jobs updatedBody) {
        Optional<Jobs> jobsOptional = jobRepository.findById(id);
            if (jobsOptional.isPresent()){
                Jobs job = jobsOptional.get();
                job.setTitle(updatedBody.getTitle());
                job.setDescription(updatedBody.getDescription());
                job.setLocation(updatedBody.getLocation());
                job.setMaxSalary(updatedBody.getMaxSalary());
                job.setMinSalary(updatedBody.getMinSalary());
                jobRepository.save(job);
                return true;
            }
        return false;
    }
}
