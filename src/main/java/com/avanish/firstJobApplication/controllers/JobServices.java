package com.avanish.firstJobApplication.controllers;

import java.util.List;

public interface JobServices {
    void createJob(Jobs job);
    List<Jobs> findAll();

    Jobs findJobById(Long id);

    void deleteById(Long id);

    boolean updateJobById(Long id, Jobs updatedBody);
}
