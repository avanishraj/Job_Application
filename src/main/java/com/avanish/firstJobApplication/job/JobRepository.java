package com.avanish.firstJobApplication.job;

import com.avanish.firstJobApplication.job.Jobs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRepository extends JpaRepository<Jobs, Long> {
}
