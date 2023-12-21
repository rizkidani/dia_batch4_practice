package com.ideaco.dia.repository;

import com.ideaco.dia.model.JobModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface JobRepository extends JpaRepository<JobModel, Integer> {
    Optional<JobModel> findByJobIdAndJobName(int jobId, String jobName);
    List<JobModel> findByJobIdOrJobName(int jobId, String jobName);

    @Query(value = "SELECT * FROM tab_job WHERE job_id = :jobId", nativeQuery = true)
    List<JobModel> findAllByNativeQuery(int jobId);

    @Query(value = "SELECT j FROM JobModel j WHERE j.jobId = :jobId")
    List<JobModel> findAllByJPQLQuery(int jobId);
}
