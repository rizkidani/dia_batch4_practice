package com.ideaco.dia.response;

import com.ideaco.dia.dto.JobDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class JobResponse {
    private String code;
    private String message;
    private List<JobDTO> data;
}
