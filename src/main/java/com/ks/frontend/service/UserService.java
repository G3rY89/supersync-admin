package com.ks.frontend.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.ks.frontend.model.SuperSyncWebshops;
import com.ks.frontend.repository.ProcessRepository;
import com.ks.frontend.repository.SuperSyncUserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private SuperSyncUserRepository superSyncUserRepository;
    private ProcessRepository processRepository;

    public UserService(SuperSyncUserRepository superSyncUserRepositoryService, ProcessRepository processRepositoryService) {
        this.superSyncUserRepository = superSyncUserRepositoryService;
        this.processRepository = processRepositoryService;
    }

    public Optional<SuperSyncWebshops> getSuperSyncUserById(Integer id) {
        return superSyncUserRepository.findById(id);
    }

    public List<SuperSyncWebshops> getSuperSyncWebshopsByWebIdentifier(String webIdentifier){
        return superSyncUserRepository.findByWebIdentifier(webIdentifier);
    }

    public List<SuperSyncWebshops> getAllusers(){
        List<SuperSyncWebshops> userList = new ArrayList<>();
        userList = superSyncUserRepository.findAll();
        return userList;
    }

    public void deleteUser(String id){
        superSyncUserRepository.deleteById(Integer.parseInt(id));
    }

    public void deleteWebshop(String id, String ApiKey){
        superSyncUserRepository.deleteById(Integer.parseInt(id));
        processRepository.deleteByApiKey(ApiKey);
    }

}