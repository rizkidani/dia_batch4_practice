package com.ideaco.dia.controller;

import com.ideaco.dia.service.JobService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/job")
public class JobController {

    private final JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping("/list")
    public String getListJob() {
        return "Hello World!";
    }

    @GetMapping("/listWithPathVariable/{jobId}")
    public String listWithPathVariable(@PathVariable("jobId") int jobId) {
        String result = "Value : " + jobId;
        return result;
    }

    @GetMapping("/listWithRequestParam")
    public String listWithRequestParam(@RequestParam("jobId") int jobId) {
        String result = "Value : " + jobId;
        return result;
    }
    @GetMapping("/listWithService")
    public String getListJobWithService() {
        return jobService.getListJob(1);
    }
}
