package com.ks.frontend.service;

import com.ks.frontend.model.Processes;
import com.ks.frontend.repository.ProcessRepository;

import org.springframework.stereotype.Service;

@Service
public class ProcessService {

    private ProcessRepository processRepository;

    public ProcessService(ProcessRepository service){
        this.processRepository = service;
    }

    public Processes getProcesses(String webshopApiKey){
        return processRepository.findByApiKey(webshopApiKey);
    }

    public void updateProcesses(Processes processes){
       processRepository.setProcesses(processes);
       processRepository.flush();
    }
}