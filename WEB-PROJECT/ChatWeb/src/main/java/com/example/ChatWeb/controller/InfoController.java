package com.example.ChatWeb.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.ChatWeb.dto.AccountDTO;
import com.example.ChatWeb.dto.UserDTO;
import com.example.ChatWeb.service.AccountService;
import com.example.ChatWeb.service.ContactService;
import com.example.ChatWeb.service.MessageService;
import com.example.ChatWeb.service.RoomService;
import com.example.ChatWeb.service.UserService;

@Controller
public class InfoController {
	@Autowired
	private AccountService accountService;
	@Autowired
	private RoomService roomService;
	@Autowired
	private MessageService messageService;
	@Autowired
	private UserService userService;
	@Autowired
	private ContactService contactService;
	private static final Logger log = LoggerFactory.getLogger(InfoController.class);
	
	@GetMapping(value = "/info")
	public String viewInfo(Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String sdt = auth.getName(); // get logged in username;
		AccountDTO accountLogin = accountService.getAccountBySoDienThoai(sdt);
		
		return callInfoPage(model, accountLogin);
	}
	
	public String callInfoPage(Model model, AccountDTO accountLogin) {
		model.addAttribute("username", accountLogin.getUsername());
		model.addAttribute("content", accountLogin.getUsername());
		return "info";
	}
}
