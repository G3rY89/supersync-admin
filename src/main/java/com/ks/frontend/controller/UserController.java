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

    @RequestMapping(value = "/deletewebidentifier", method = RequestMethod.POST)
    public void removeUser(@RequestParam("userid") String userId, @RequestParam("apiKey") String apiKey){
        userService.deleteUser(userId, apiKey);
    }

    @RequestMapping(value = "/deletewebshop", method = RequestMethod.POST)
    public void removeWebshop(@RequestParam("webshopId") String webshopId){
        userService.deleteWebshop(webshopId);
    }
}