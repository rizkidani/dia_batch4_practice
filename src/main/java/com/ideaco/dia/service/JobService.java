package com.ideaco.dia.service;

import com.ideaco.dia.model.JobModel;
import com.ideaco.dia.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobService {

    @Autowired
    private JobRepository jobRepository;

    public String getDataJob(int id){
        String result = "";
        if (id == 1){
             result = "Number 1";
        } else if (id == 2){
            result = "Number 2";
        }

        return result;
    }

    public Optional<JobModel> getDataOptionalWithModel(int jobId) {
        Optional<JobModel> data = jobRepository.findById(jobId);

        return data;
    }

    public List<JobModel> getDataListWithModel() {
        List<JobModel> data = jobRepository.findAll();

        return data;
    }

    public Optional<JobModel> getDataOptionalByParams(int jobId, String jobName) {
        Optional<JobModel> data = jobRepository.findByJobIdAndJobName(jobId, jobName);

        return data;
    }

    public List<JobModel> getDataListByParams(int jobId, String jobName) {
        List<JobModel> data = jobRepository.findByJobIdOrJobName(jobId, jobName);

        return data;
    }

    public List<JobModel> getDataListWithQuery(int jobId) {
//        List<JobModel> data = jobRepository.findAllByNativeQuery(jobId);
        List<JobModel> data = jobRepository.findAllByJPQLQuery(jobId);

        return data;
    }
}
