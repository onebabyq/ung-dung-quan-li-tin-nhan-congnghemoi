package com.example.ChatWeb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.ChatWeb.dto.UserDTO;
import com.example.ChatWeb.service.UserService;

@RestController
public class LoginController {
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	    public String viewSign(Model model) {
	    	return "signin";
	    }
	 
	@RequestMapping(value = "/register", method = RequestMethod.POST)
 //   public String register(@RequestBody UserDTO user) {
	public String register() {
		UserDTO user = new UserDTO();
		user.setEnable(true);
		user.setSoDienThoai("1234567891");
		user.setPassword("12345");
		userService.sendRegister(user);
		
    	return "signin";
    }
}
