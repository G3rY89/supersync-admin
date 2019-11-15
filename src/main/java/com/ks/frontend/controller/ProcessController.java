package com.ks.frontend.controller;

import com.ks.frontend.model.Processes;
import com.ks.frontend.service.ProcessService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProcessController{

    @Autowired
    ProcessService processService;

    public ProcessController(ProcessService service){
        this.processService = service;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public void updateProcesses(@RequestBody Processes processes){
       processService.updateProcesses(processes);
    }
    
}