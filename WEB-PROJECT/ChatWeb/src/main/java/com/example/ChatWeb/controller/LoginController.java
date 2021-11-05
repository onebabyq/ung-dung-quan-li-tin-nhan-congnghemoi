package com.example.ChatWeb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ChatWeb.dto.UserDTO;
import com.example.ChatWeb.service.UserService;

@RestController
public class LoginController {
	@Autowired
	private UserService userService;
	
	@RequestMapping("/testLogin/{sdt}")
	public String testPage(@PathVariable String sdt) {
		UserDTO user =userService.getUserBySoDienThoai(sdt);
		if(user==null)
			return "redirect:/login";
		return user.toString();
	}
	
}
