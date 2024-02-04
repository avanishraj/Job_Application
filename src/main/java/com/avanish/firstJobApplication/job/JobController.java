package com.avanish.firstJobApplication.job;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jobs")
public class JobController {

    public JobController(JobServices jobServices) {
        this.jobServices = jobServices;
    }

    private final JobServices jobServices;


    @GetMapping
    private ResponseEntity<List<Jobs>> findAll(){
        return ResponseEntity.ok(jobServices.findAll()); // or ResponseEntity<>(jobServices.findAll(), HttpStatus.OK);
    }

    @PostMapping
    private ResponseEntity<String> createJob(@RequestBody Jobs job){
        jobServices.createJob(job);
        return ResponseEntity.ok("Job created successfully");
    }

    @GetMapping("/{id}")
    private ResponseEntity<Jobs> findJobById(@PathVariable Long id){
        Jobs job = jobServices.findJobById(id);
        if(job != null) return new ResponseEntity<>(job, HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<String> deleteJobById(@PathVariable Long id){
        jobServices.deleteById(id);
        return ResponseEntity.ok("Successfully deleted");
    }

    @PutMapping("/{id}")
    private ResponseEntity<String> updateJobById(@PathVariable Long id, @RequestBody Jobs updatedBody){
        boolean updated = jobServices.updateJobById(id, updatedBody);
        if(updated){
            return new ResponseEntity<>("Job updated successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
