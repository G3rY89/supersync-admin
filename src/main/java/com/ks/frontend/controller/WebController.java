package com.ks.frontend.controller;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import com.ks.frontend.model.Processes;
import com.ks.frontend.model.SuperSyncWebshops;
import com.ks.frontend.service.ProcessService;
import com.ks.frontend.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@CrossOrigin
@Controller
public class WebController {

    @Autowired
    private UserService userService;

    @Autowired
    private ProcessService processervice;

    public WebController(UserService service) {
        this.userService = service;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String renderIndex() {
        return "index";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String renderLogin() {
        return "login";
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String showAllUsers(Model model) {
        List<SuperSyncWebshops> users = userService.getAllusers();
        Iterator<SuperSyncWebshops> iterator = users.iterator();
        HashSet<String> seen = new HashSet<String>();
        while (iterator.hasNext()) {
            SuperSyncWebshops p = iterator.next();
            if (seen.contains(p.webIdentifier)) {
                  iterator.remove();
            } else { 
                  seen.add(p.webIdentifier);
            }
       }        
        model.addAttribute("users", users);
        return "users";
    }

    @RequestMapping(value = "/user/{webIdentifier}", method = RequestMethod.GET)
    public String userDetails(@PathVariable("webIdentifier") String webIdentifier, Model model) {
        List<SuperSyncWebshops> webshops = userService.getSuperSyncWebshopsByWebIdentifier(webIdentifier);
        model.addAttribute("webshops", webshops);
        return "user";
    }

    @RequestMapping(value = "/modify/{webshopApiKey}", method = RequestMethod.GET)
    public String modifyUser(@PathVariable("webshopApiKey") String webshopApiKey, Model model) {
        Processes processes = processervice.getProcesses(webshopApiKey);
        model.addAttribute("processes", processes);
        return "modify";
    }
}
