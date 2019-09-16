package com.ks.frontend.controller;

import java.util.List;

import com.ks.frontend.model.SuperSyncUser;
import com.ks.frontend.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@CrossOrigin
@Controller
public class WebController {

    @Autowired
    private UserService userService;

    public WebController(UserService service){
        this.userService = service;
    }


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String renderIndex(){
        return "index";
    }
    
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String renderLogin(){
        return "login";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registerUser(){
        return "registration";
    }
    
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String showAllUsers(Model model){
        List<SuperSyncUser> users = userService.getAllusers();
        model.addAttribute("users", users);
        return "users";
    }
}
