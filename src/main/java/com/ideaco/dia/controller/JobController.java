package com.ideaco.dia.controller;

import com.ideaco.dia.dto.JobDTO;
import com.ideaco.dia.model.JobModel;
import com.ideaco.dia.response.HandlerResponse;
import com.ideaco.dia.response.JobResponse;
import com.ideaco.dia.service.FileService;
import com.ideaco.dia.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/job")
public class JobController {

//    @Autowired
//    private JobService jobService;
//    @Autowired
//    private FileService fileService;

    private JobService jobService;
    private FileService fileService;

    public JobController(JobService jobService, FileService fileService) {
        this.jobService = jobService;
        this.fileService = fileService;
    }

    /* --------------------- GET ------------------ */

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

    /* --------------------- POST ------------------ */

    @PostMapping("/createJobWithParams")
    public JobModel postCreateJob(@RequestParam("jobName") String jobName,
                                  @RequestParam("jobDesc") String jobDesc,
                                  @RequestParam("jobSalary") int jobSalary) {
        JobModel data = jobService.postCreateJob(jobName, jobDesc, jobSalary);

        return data;
    }

    @PostMapping("/createJobWithBody")
    public JobModel postCreateJobWithBody(@RequestBody JobModel jobModel) {
        return jobService.postCreateJobWithBody(jobModel);
    }

    @PostMapping("/createJobWithBodyMultiple")
    public List<JobModel> postCreateJobWithBodyMultiple(@RequestBody List<JobModel> jobModels) {
        return jobService.postCreateJobWithBodyMultiple(jobModels);
    }

    /* --------------------- PUT ------------------ */

    @PutMapping("/updateJobWithParams")
    public JobModel putUpdateJobWithParams(@RequestParam("jobId") int jobId,
                                 @RequestParam("jobName") String jobName,
                                 @RequestParam("jobDesc") String jobDesc,
                                 @RequestParam("jobSalary") int jobSalary) {
        return jobService.putUpdateJobWithParams(jobId, jobName, jobDesc, jobSalary);
    }

    @PutMapping("/updateJobWithBody")
    public JobModel putUpdateJobWithBody(@RequestBody JobModel jobModel) {
        return jobService.putUpdateJobWithBody(jobModel);
    }

    /* --------------------- PATCH ------------------ */

    @PatchMapping("/updateJobWithParamsPatch")
    public JobModel patchUpdateJobWithParamsPatch(@RequestParam("jobId") int jobId,
                                                  @RequestParam("jobName") String jobName) {
        return jobService.patchUpdateJobWithParams(jobId, jobName);
    }

    /* --------------------- DELETE ------------------ */

    @DeleteMapping("/deleteJob")
    public String deleteJob(@RequestParam("jobId") int jobId) {
        boolean response = jobService.deleteJob(jobId);

        if (response) {
            return "Delete Success";
        } else {
            return "Delete Failed";
        }
    }

    /* --------------------- POST MULTIPART ------------------ */

    @PostMapping("/uploadFile")
    public boolean uploadJobImage(@RequestParam("file") MultipartFile file) {
        return fileService.saveFile(file);
    }

    /* --------------------- DTO ------------------ */

    @GetMapping("/dataWithDTO")
    public JobDTO dataWithDTO(@RequestParam("jobId") int jobId) {
        return jobService.dataWithDTO(jobId);
    }

    @GetMapping("/dataListWithDTO")
    public List<JobDTO> dataListWithDTO() {
        return jobService.dataListWithDTO();
    }

    @PostMapping("/createJobWithResponseData")
    public HandlerResponse createJobWithResponseData(@RequestParam("jobName") String jobName,
                                                     @RequestParam("jobDesc") String jobDesc,
                                                     @RequestParam("jobSalary") int jobSalary) {
        HandlerResponse data = jobService.postCreateJobWithHandlerResponse(jobName, jobDesc, jobSalary);

        try {
            return data;
        } catch (Exception e) {
            e.printStackTrace();

            HandlerResponse response = new HandlerResponse();
            response.setCode("02");
            response.setMessage("Error!");
            return response;
        }
    }

    @GetMapping("/dataListWithResponseData")
    public JobResponse dataListWithResponseData() {
        JobResponse data = jobService.getListJobWithHandlerResponse();

        return data;
    }
}
