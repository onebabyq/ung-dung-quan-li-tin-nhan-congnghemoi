package com.example.ChatWeb.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

import com.example.ChatWeb.model.ChatMessage;

@Controller
public class ChatController {
	
	private static final Logger log = LoggerFactory.getLogger(ChatController.class);
	
    @MessageMapping("/chat.sendMessage")
    @SendTo("/topic/public")
    public ChatMessage sendMessage(@Payload ChatMessage chatMessage) {
    	log.info("CALL SUCCESSFULLY!!!!!!!");
    	System.out.println("CALL SUCESsFUll!");
        return chatMessage;
    }

    @MessageMapping("/chat.addUser")
    @SendTo("/topic/public")
    public ChatMessage addUser(@Payload ChatMessage chatMessage, 
                               SimpMessageHeaderAccessor headerAccessor) {
    	
        // Add username in web socket session
        headerAccessor.getSessionAttributes().put("username", chatMessage.getSender());
        return chatMessage;
    }

}