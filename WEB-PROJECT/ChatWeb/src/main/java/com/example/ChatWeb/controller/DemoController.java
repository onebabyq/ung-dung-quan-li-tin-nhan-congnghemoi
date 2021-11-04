package com.example.ChatWeb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DemoController {

	/*
	 * private final BookService bookService;
	 * 
	 * public BookController(BookService bookService) { this.bookService =
	 * bookService; }
	 */

    @GetMapping("/view/{username}")
    public String viewBooks(@PathVariable("username") String username,Model model) {
        model.addAttribute("username", username);
    	//System.out.println("HELLO SON");
        return "chat";
    }
}