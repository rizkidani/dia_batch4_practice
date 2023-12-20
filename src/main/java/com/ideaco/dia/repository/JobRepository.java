package com.ideaco.dia.repository;

import com.ideaco.dia.model.JobModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface JobRepository extends JpaRepository<JobModel, Integer> {
//    Optional<JobModel> findByJobId(String jobId);
}
