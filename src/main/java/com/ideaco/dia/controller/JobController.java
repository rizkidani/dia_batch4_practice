package com.ideaco.dia.controller;

import com.ideaco.dia.model.JobModel;
import com.ideaco.dia.service.JobService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/job")
public class JobController {

    private final JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping("/data")
    public String getData() {
        return "Hello World!";
    }

    @GetMapping("/dataWithPathVariable/{jobId}")
    public String getDataWithPathVariable(@PathVariable("jobId") int jobId) {
        String result = "Value : " + jobId;
        return result;
    }

    @GetMapping("/dataWithRequestParam")
    public String getDataWithRequestParam(@RequestParam("jobId") int jobId) {
        String result = "Value : " + jobId;
        return result;
    }

    @GetMapping("/dataWithService")
    public String getDataWithService() {
        return jobService.getDataJob(1);
    }

    @GetMapping("/dataOptionalWithModel")
    public Optional<JobModel> getDataWithModel(@RequestParam("jobId") int jobId) {
        Optional<JobModel> data = jobService.getDataOptionalWithModel(jobId);

        return data;
    }

    @GetMapping("/dataListWithModel")
    public List<JobModel> getDataListWithModel() {
        List<JobModel> data = jobService.getDataListWithModel();

        return data;
    }

    @GetMapping("/dataOptionalWithParams")
    public Optional<JobModel> getDataOptionalWithParams(@RequestParam("jobId") int jobId,
                                                        @RequestParam("jobName") String jobName) {
        Optional<JobModel> data = jobService.getDataOptionalByParams(jobId, jobName);

        return data;
    }

    @GetMapping("/dataListWithParams")
    public List<JobModel> getDataListWithParams(@RequestParam("jobId") int jobId,
                                                @RequestParam("jobName") String jobName) {
        List<JobModel> data = jobService.getDataListByParams(jobId, jobName);

        return data;
    }

    @GetMapping("/dataListWithQuery")
    public List<JobModel> getDataListWithQuery(@RequestParam("jobId") int jobId) {
        List<JobModel> data = jobService.getDataListWithQuery(jobId);

        return data;
    }
}
