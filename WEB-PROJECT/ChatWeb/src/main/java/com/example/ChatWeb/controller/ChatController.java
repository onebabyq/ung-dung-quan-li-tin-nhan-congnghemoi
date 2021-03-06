package com.example.ChatWeb.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.ChatWeb.dto.AccountDTO;
import com.example.ChatWeb.dto.ContactDTO;
import com.example.ChatWeb.dto.MessageDTO;
import com.example.ChatWeb.dto.RoomDTO;
import com.example.ChatWeb.dto.UserDTO;
import com.example.ChatWeb.model.ChatMessage;
import com.example.ChatWeb.model.ChatMessage.MessageType;
import com.example.ChatWeb.model.EchoModel;
import com.example.ChatWeb.model.InviteMessage;
import com.example.ChatWeb.service.AccountService;
import com.example.ChatWeb.service.ContactService;
import com.example.ChatWeb.service.MessageService;
import com.example.ChatWeb.service.RoomService;
import com.example.ChatWeb.service.SocketService;
import com.example.ChatWeb.service.UserService;


@Controller
public class ChatController {
	// @Autowired
	// FilesStorageService storageService;
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
	private static final Logger log = LoggerFactory.getLogger(ChatController.class);

	@Autowired
	private SimpMessageSendingOperations messagingTemplate;
	@Autowired
	SocketService socketService;

	@MessageMapping("/hello-msg-mapping")
	@SendTo("/topic/greetings")
	EchoModel echoMessageMapping(@Payload String message) {
		log.info("Tin nhan: "+message);
		log.debug("React to hello-msg-mapping");
		return new EchoModel(message.trim());
	}

	@RequestMapping(value = "/hello-convert-and-send", method = RequestMethod.POST)
	void echoConvertAndSend(@RequestParam("msg") String message) {
		socketService.echoMessage(message);
	}

	@MessageMapping("/chat/{roomId}/sendMessage")
	public void sendMessage(@DestinationVariable String roomId, @Payload ChatMessage chatMessage) {
		log.info(chatMessage.toString());
		messageService.createByChatMessage(chatMessage);
		if (chatMessage.getContentType().equals("FILE") || chatMessage.getContentType().equals("VIDEO"))
			chatMessage.setFileName(convertUrlToFileName(chatMessage.getContent()));
		messagingTemplate.convertAndSend("/topic/" + roomId, chatMessage);
	}

	@MessageMapping("/chat/{roomId}/sendInvite")
	public void sendInvite(@DestinationVariable String roomId, @Payload InviteMessage inviteMessage) {

		UserDTO user = userService.getUserBySoDienThoai(inviteMessage.getTelReceiver());
		inviteMessage.setIdReceiver(user.getId());
		log.info(inviteMessage.toString());
		contactService.createByInviteMessage(inviteMessage);
		messagingTemplate.convertAndSend("/topic/" + roomId, inviteMessage);
	}

	@MessageMapping("/chat/{roomId}/addUser")
	public void addUser(@DestinationVariable String roomId, @Payload ChatMessage chatMessage,
			SimpMessageHeaderAccessor headerAccessor) {
		log.info(chatMessage.toString());
		String currentRoomId = (String) headerAccessor.getSessionAttributes().put("room_id", roomId);
		if (currentRoomId != null) {
			System.out.println(chatMessage.getSender() + " v???a r???i kh???i ph??ng " + roomId);
			ChatMessage leaveMessage = new ChatMessage();
			leaveMessage.setType(MessageType.LEAVE);
			leaveMessage.setSender(chatMessage.getSender());
			messagingTemplate.convertAndSend("/topic/" + currentRoomId, leaveMessage);
		}
		headerAccessor.getSessionAttributes().put("username", chatMessage.getSender());
		messagingTemplate.convertAndSend("/topic/" + roomId, chatMessage);
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
		String sdt = auth.getName(); // get logged in username;
		AccountDTO accountLogin = accountService.getAccountBySoDienThoai(sdt);

		return callChatPage(model, accountLogin);
	}

	@GetMapping("/dual/withFriend/{friendId}")
	public String chatwithfriend(Model model, @PathVariable long friendId) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String sdt = auth.getName(); // get logged in username;
		AccountDTO accountLogin = accountService.getAccountBySoDienThoai(sdt);
		RoomDTO room = roomService.getRoomDualByTwoAccountId(accountLogin.getId(), friendId);
		List<MessageDTO> listMessage = messageService.getListMessageByMessageId(room.getId());
		setFileName(listMessage);
		model.addAttribute("friendName", accountService.getAccountById(friendId).getUsername());
		model.addAttribute("listMessage", listMessage);
		model.addAttribute("friendId", friendId);
		model.addAttribute("roomId", room.getId());
		return callChatPage(model, accountLogin);
	}

	@GetMapping("/accept/{friendId}")
	public String acceptFriend(Model model, @PathVariable long friendId) {

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String sdt = auth.getName(); // get logged in username;
		AccountDTO accountLogin = accountService.getAccountBySoDienThoai(sdt);

		long accountId = accountLogin.getId();

		RoomDTO newRoom = new RoomDTO();
		newRoom.setAdminId(accountLogin.getId());
		newRoom.setDeleted(false);
		newRoom.setType("Dual");

		roomService.createRoom(newRoom, accountId, friendId);
		contactService.updateAcceptContact(accountId, friendId);

		List<AccountDTO> listAccount = new ArrayList<AccountDTO>();
		listAccount.add(accountLogin);
		listAccount.add(accountService.getAccountById(friendId));
		newRoom.setAccounts(listAccount);

		return callChatPage(model, accountLogin);
	}

	@PostMapping("/findSDT")
	public String findSDT(Model model, @RequestParam String soDienThoai) {

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String sdt = auth.getName(); // get logged in username;
		AccountDTO accountLogin = accountService.getAccountBySoDienThoai(sdt);

		UserDTO userFinded = userService.getUserBySoDienThoai(soDienThoai);

		model.addAttribute("userFinded", userFinded);
		return callChatPage(model, accountLogin);
	}

	public String callChatPage(Model model, AccountDTO accountLogin) {

		List<ContactDTO> listContact = contactService.getListContactByAccountId(accountLogin.getId());
		for (ContactDTO c : listContact) {
			c.setFriend(accountService.getAccountById(c.getFriendId()));
		}
		model.addAttribute("listContact", listContact);
		model.addAttribute("account", accountLogin);
		// System.out.println("HELLO SON");
		return "chat";

	}

	public void setFileName(List<MessageDTO> listMessage) {
		for (MessageDTO m : listMessage) {
			if (m.getContentType().equals("FILE")) {
				m.setFileName(convertUrlToFileName(m.getContent()));
			}
		}
	}

	public String convertUrlToFileName(String url) {
		File f = new File(url);
		return f.getName();
	}
}