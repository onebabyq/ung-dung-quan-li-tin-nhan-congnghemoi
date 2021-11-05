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

	/*
	 * private final BookService bookService;
	 * 
	 * public BookController(BookService bookService) { this.bookService =
	 * bookService; }
	 */

    //@GetMapping("/view/{username}")
   // public String viewBooks(@PathVariable("username") String username,Model model) {
    @GetMapping("/chat")
    public String viewBooks(Model model) {
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName(); //get logged in username
        model.addAttribute("username", name);
    	//System.out.println("HELLO SON");
        return "chat";
    }
    @GetMapping("/view2")
    public String viewBooks2(Model model) {
        model.addAttribute("username", "toanlayloi");
    	//System.out.println("HELLO SON");
        return "chat";
    }
    
    @GetMapping({"/home", "/"})
    public String viewHome(Model model) {
    	model.addAttribute("username", "toanlayloi");
    	model.addAttribute("appname", "APPCHAT");
    	return "home";
    }
    
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String viewSign(Model model) {
    	return "signin";
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