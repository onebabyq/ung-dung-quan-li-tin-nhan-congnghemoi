package com.example.ChatWeb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DemoController {

	/*
	 * private final BookService bookService;
	 * 
	 * public BookController(BookService bookService) { this.bookService =
	 * bookService; }
	 */

    @GetMapping("/view")
    public String viewBooks() {
        //model.addAttribute("books", bookService.getBooks());
    	//System.out.println("HELLO SON");
        return "chat";
    }
}