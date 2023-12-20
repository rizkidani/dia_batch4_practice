package com.ideaco.dia.service;

import org.springframework.stereotype.Service;

@Service
public class JobService {

    public String getListJob(int id){
        String result = "";
        if (id == 1){
             result = "Number 1";
        } else if (id == 2){
            result = "Number 2";
        }

        return result;
    }
}
