package com.example.ChatWeb.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.ChatWeb.model.ChatMessage;
import com.example.ChatWeb.service.AccountService;

@Controller
public class ChatController {
	@Autowired
	private AccountService accountService;
	private static final Logger log = LoggerFactory.getLogger(ChatController.class);
	
    @MessageMapping("/chat.sendMessage")
    @SendTo("/topic/public")
    public ChatMessage sendMessage(@Payload ChatMessage chatMessage) {
    	log.info(chatMessage.toString());
        return chatMessage;
    }

    @MessageMapping("/chat.addUser")
    @SendTo("/topic/public")
    public ChatMessage addUser(@Payload ChatMessage chatMessage, 
                               SimpMessageHeaderAccessor headerAccessor) {
    	log.info(chatMessage.toString());
        // Add username in web socket session
        headerAccessor.getSessionAttributes().put("username", chatMessage.getSender());
        return chatMessage;
    }
    
    @GetMapping("/chat")
    public String viewBooks(Model model) {
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String sdt = auth.getName(); //get logged in username
       
        model.addAttribute("username", accountService.getAccountBySoDienThoai(sdt).getUsername());
    	//System.out.println("HELLO SON");
        return "chat";
    }

}