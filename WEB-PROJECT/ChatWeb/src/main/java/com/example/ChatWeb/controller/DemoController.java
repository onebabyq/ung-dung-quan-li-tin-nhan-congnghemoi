package com.example.ChatWeb.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DemoController {


    
    @GetMapping({"/home", "/"})
    public String viewHome(Model model) {
    	model.addAttribute("username", "toanlayloi");
    	model.addAttribute("appname", "APPCHAT");
    	return "home";
    }
    
   
    
    @GetMapping("/info")
    public String viewInfo(Model model) {
    	model.addAttribute("firstname","Toàn");
    	model.addAttribute("lastname","Lê");
    	model.addAttribute("email","lvtoan.cv@gmail.com");
    	model.addAttribute("content","Đây là trang cá nhân của tôi");
    	return "info";
    }
    
    @GetMapping("/admin")
    public String viewAdmin(Model model) {
    	return "admin/home";
    }
}