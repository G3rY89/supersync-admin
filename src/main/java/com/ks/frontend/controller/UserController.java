package com.ks.frontend.controller;

import com.ks.frontend.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserController{

    @Autowired
    private UserService userService;

    public UserController(UserService service){
        this.userService = service;
    }

    @RequestMapping(value = "/adduser", method = RequestMethod.POST)
    public void addUser(@RequestParam("webIdentifier") String webIdentifier, @RequestParam("webPassword") String webPassword){
        userService.addUser(webIdentifier, webPassword);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public void removeUser(@RequestParam("userid") String userId){
        userService.deleteUser(userId);
    }
}