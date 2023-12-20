package com.ideaco.dia.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "tab_job")
public class JobModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "job_id")
    private int jobId;
    @Column(name = "job_name")
    private String jobName;
    @Column(name = "job_desc")
    private String jobDesc;
    @Column(name = "job_salary")
    private int jobSalary;
}
