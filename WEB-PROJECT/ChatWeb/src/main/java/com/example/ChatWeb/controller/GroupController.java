package com.example.ChatWeb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.ChatWeb.dto.AccountDTO;
import com.example.ChatWeb.dto.MessageDTO;
import com.example.ChatWeb.dto.RoomDTO;
import com.example.ChatWeb.service.AccountService;
import com.example.ChatWeb.service.MessageService;
import com.example.ChatWeb.service.RoomService;
import static com.example.ChatWeb.controller.ChatController.*;
@Controller
public class GroupController {
	@Autowired
	private AccountService accountService;
	@Autowired
	private RoomService roomService;
	@Autowired
	private MessageService messageService;
	
	@GetMapping("/group")
	public String viewGroupPage(Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String sdt = auth.getName(); // get logged in username;
		AccountDTO accountLogin = accountService.getAccountBySoDienThoai(sdt);

		return callGroupPage(model, accountLogin);
	}
	
	@GetMapping("/group/{id}")
	public String viewGroupChatPage(Model model,@PathVariable long id) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String sdt = auth.getName(); // get logged in username;
		AccountDTO accountLogin = accountService.getAccountBySoDienThoai(sdt);
		RoomDTO room = roomService.getRoomById(id);
		List<MessageDTO> listMessage = messageService.getListMessageByMessageId(room.getId());
		setFileName(listMessage);
		
		model.addAttribute("listMessage", listMessage);
		
		return callGroupPage(model, accountLogin);
	}
	
	public String callGroupPage(Model model, AccountDTO accountLogin) {

		List<RoomDTO> listGroup = roomService.getListGroupByAccountId(accountLogin.getId());
	
		model.addAttribute("listGroup", listGroup);
		model.addAttribute("account", accountLogin);
		// System.out.println("HELLO SON");
		return "group";

	}
}
