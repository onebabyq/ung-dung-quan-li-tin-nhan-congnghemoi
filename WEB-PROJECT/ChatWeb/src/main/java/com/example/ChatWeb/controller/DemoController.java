package com.example.ChatWeb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {


    
    @GetMapping({"/home", "/"})
    public String viewHome(Model model) {
    	model.addAttribute("username", "toanlayloi");
    	model.addAttribute("appname", "APPCHAT");
    	return "home";
    }
    
    
    
    @GetMapping("/admin")
    public String viewAdmin(Model model) {
    	return "admin/home";
    }
}