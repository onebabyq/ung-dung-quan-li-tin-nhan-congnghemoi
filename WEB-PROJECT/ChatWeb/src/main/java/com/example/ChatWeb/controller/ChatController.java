package com.example.ChatWeb.controller;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.ChatWeb.dto.AccountDTO;
import com.example.ChatWeb.model.ChatMessage;
import com.example.ChatWeb.model.ChatMessage.MessageType;
import com.example.ChatWeb.service.AccountService;

@Controller
public class ChatController {
	@Autowired
	private AccountService accountService;
	private static final Logger log = LoggerFactory.getLogger(ChatController.class);

	  @Autowired
	  private SimpMessageSendingOperations messagingTemplate;

	  @MessageMapping("/chat/{roomId}/sendMessage")
	  public void sendMessage(@DestinationVariable String roomId, @Payload ChatMessage chatMessage) {
	    messagingTemplate.convertAndSend("/topic/"+ roomId, chatMessage);
	  }

	  @MessageMapping("/chat/{roomId}/addUser")
	  public void addUser(@DestinationVariable String roomId, @Payload ChatMessage chatMessage,
	      SimpMessageHeaderAccessor headerAccessor) {
	    String currentRoomId = (String) headerAccessor.getSessionAttributes().put("room_id", roomId);
	    if (currentRoomId != null) {
	      ChatMessage leaveMessage = new ChatMessage();
	      leaveMessage.setType(MessageType.LEAVE);
	      leaveMessage.setSender(chatMessage.getSender());
	      messagingTemplate.convertAndSend("/topic/"+ currentRoomId, leaveMessage);
	    }
	    headerAccessor.getSessionAttributes().put("username", chatMessage.getSender());
	    messagingTemplate.convertAndSend("/topic/"+ roomId, chatMessage);
	  }
//    @MessageMapping("/chat.sendMessage")
//    @SendTo("/topic/public")
//    public ChatMessage sendMessage(@Payload ChatMessage chatMessage) {
//    	log.info(chatMessage.toString());
//        return chatMessage;
//    }
//
//    @MessageMapping("/chat.addUser")
//    @SendTo("/topic/public")
//    public ChatMessage addUser(@Payload ChatMessage chatMessage, 
//                               SimpMessageHeaderAccessor headerAccessor) {
//    	log.info(chatMessage.toString());
//        // Add username in web socket session
//        headerAccessor.getSessionAttributes().put("username", chatMessage.getSender());
//        return chatMessage;
//    }
    
    @GetMapping("/chat")
    public String viewBooks(Model model) {
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String sdt = auth.getName(); //get logged in username;
        AccountDTO accountLogin = accountService.getAccountBySoDienThoai(sdt);
        List<AccountDTO> listFriend = accountService.getListFriendByAccountId(accountLogin.getId());
       
        int idSocket;
        if(accountLogin.getId()%2==1)
        	idSocket = 1;
        else idSocket=2;
        model.addAttribute("idSocket", idSocket);
        model.addAttribute("listFriend", listFriend);
        model.addAttribute("username", accountLogin.getUsername());
    	//System.out.println("HELLO SON");
        return "chat";
    }

}