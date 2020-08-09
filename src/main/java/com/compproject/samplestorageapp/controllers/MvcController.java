package com.compproject.samplestorageapp.controllers;

import com.compproject.samplestorageapp.model.samples.Sample;
import com.compproject.samplestorageapp.service.SampleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import java.util.List;

@Controller
public class MvcController {

    private final SampleService sampleService;

    public MvcController(SampleService sampleService){
        this.sampleService = sampleService;
    }

    @RequestMapping(value = "/index")
    public String viewIndex(){
        return "index";
    }

    @RequestMapping(value = "/login")
        public String viewLogin(){
            return "login";
        }

    @GetMapping(value = "/user")
    public String viewUser(){
        return "userMain";
    }

    @GetMapping(value = "/admin")
    public String viewAdmin(){
        return "adminMain";
    }

    @GetMapping(value = "/user/search_all")
    public String viewSamples(Model model){
        List<Sample> listSamples = sampleService.listAll();
        model.addAttribute("listSamples", listSamples);

        return "userSearch";
    }
}




