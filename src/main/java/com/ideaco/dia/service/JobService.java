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

    public JobModel postCreateJob(String jobName, String jobDesc, int jobSalary) {
        JobModel jobModel = new JobModel();
        jobModel.setJobName(jobName);
        jobModel.setJobDesc(jobDesc);
        jobModel.setJobSalary(jobSalary);

        return jobRepository.save(jobModel);
    }

    public JobModel postCreateJobWithBody(JobModel jobModel) {
        return jobRepository.save(jobModel);
    }

    public List<JobModel> postCreateJobWithBodyMultiple(List<JobModel> jobModels) {
        return jobRepository.saveAll(jobModels);
    }

    public JobModel putUpdateJobWithParams(int jobId, String jobName, String jobDesc, int jobSalary) {
        Optional<JobModel> jobModelOptional = jobRepository.findById(jobId);

        if (jobModelOptional.isEmpty()){
            return null;
        }

        JobModel jobModel = jobModelOptional.get();
        jobModel.setJobName(jobName);
        jobModel.setJobDesc(jobDesc);
        jobModel.setJobSalary(jobSalary);

        return jobRepository.save(jobModel);
    }
    public JobModel putUpdateJobWithBody(JobModel jobModel) {
        int jobId = jobModel.getJobId();
        Optional<JobModel> jobModelOptional = jobRepository.findById(jobId);

        if (jobModelOptional.isEmpty()){
            return null;
        }

        return jobRepository.save(jobModel);
    }

    public JobModel patchUpdateJobWithParams(int jobId, String jobName) {
        Optional<JobModel> jobModelOptional = jobRepository.findById(jobId);

        if (jobModelOptional.isEmpty()) {
            return null;
        }

        JobModel jobModel = jobModelOptional.get();
        jobModel.setJobName(jobName);

        return jobRepository.save(jobModel);
    }

    public boolean deleteJob(int jobId) {
        Optional<JobModel> jobModelOptional = jobRepository.findById(jobId);

        if (jobModelOptional.isEmpty()) {
            return false;
        }

        // Option 1
//        jobRepository.delete(jobModelOptional.get());
        // Option 2
        jobRepository.deleteById(jobId);
        return true;
    }
}
