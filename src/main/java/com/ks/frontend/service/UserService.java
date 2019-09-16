package com.ks.frontend.service;

import java.util.ArrayList;
import java.util.List;

import com.ks.frontend.model.SuperSyncUser;
import com.ks.frontend.repository.SuperSyncUserRepository;
import com.ks.frontend.repository.UserWebshopsRepository;

import org.springframework.stereotype.Service;

@Service
public class UserService{

    private SuperSyncUserRepository superSyncUserRepository;
    private UserWebshopsRepository userWebshopsRepository;

    public UserService(SuperSyncUserRepository superSyncUserRepositoryService, UserWebshopsRepository userWebshopsRepositoryService){
        this.superSyncUserRepository = superSyncUserRepositoryService;
        this.userWebshopsRepository = userWebshopsRepositoryService;
    }


    public List<SuperSyncUser> getAllusers(){
        List<SuperSyncUser> userList = new ArrayList<>();
        userList = superSyncUserRepository.findAll();
        return userList;
    }

    public void addUser(String webIdentifier, String webPassword){
        superSyncUserRepository.save(new SuperSyncUser(webIdentifier, webPassword));
    }

    public void deleteUser(String id){
        superSyncUserRepository.deleteById(Integer.parseInt(id));
    }

}