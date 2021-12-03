package com.example.ChatWeb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.ChatWeb.dto.AccountDTO;
import com.example.ChatWeb.dto.UserDTO;
import com.example.ChatWeb.service.UserService;

@Controller
public class LoginController {
	@Autowired
	private UserService userService;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	    public String viewSign(Model model) {
			model.addAttribute("account",new AccountDTO());
			model.addAttribute("user", new UserDTO());
	    	return "signin";
	    }
	 
	@RequestMapping(value = "/register", method = RequestMethod.POST, consumes = {"application/x-www-form-urlencoded"} )
    public String register( UserDTO user,@RequestParam String hoten) {
	//public String register() {
		AccountDTO account = new AccountDTO();
		account.setUsername(hoten);
		user.setAccount(account);
		user.setEnable(true);
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		//userService.sendRegister(user);
		userService.sendRegister(user);
    	return "login";
    }
}
