package com.example.ChatWeb.controller;

import java.util.ArrayList;
import java.util.List;

import com.example.ChatWeb.dto.UserDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
		model.addAttribute("roomId", room.getId());
		model.addAttribute("roomName", room.getName());
		return callGroupPage(model, accountLogin);
	}
	
	public String callGroupPage(Model model, AccountDTO accountLogin) {

		List<RoomDTO> listGroup = roomService.getListGroupByAccountId(accountLogin.getId());
	
		model.addAttribute("listGroup", listGroup);
		model.addAttribute("account", accountLogin);
		// System.out.println("HELLO SON");
		return "group";

	}


	@PostMapping("/addMembers/{roomId}")
	public String addMembers(Model model, @RequestParam List<Long> ckb_friends,@PathVariable long roomId) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String sdt = auth.getName(); // get logged in username;
		AccountDTO accountLogin = accountService.getAccountBySoDienThoai(sdt);

		roomService.addMembers(ckb_friends,roomId);


		return "redirect:/group/"+roomId;
	}
	@PostMapping("/removeMembers/{roomId}")
	public String removeMembers(Model model, @RequestParam List<Long> ckb_friends,@PathVariable long roomId) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String sdt = auth.getName(); // get logged in username;
		AccountDTO accountLogin = accountService.getAccountBySoDienThoai(sdt);

		roomService.removeMembers(ckb_friends,roomId);


		return "redirect:/group/"+roomId;
	}
	@PostMapping("/updateRoomName/{roomId}")
	public String updateRoomName(Model model, @RequestParam String roomName,@PathVariable long roomId) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String sdt = auth.getName(); // get logged in username;
		AccountDTO accountLogin = accountService.getAccountBySoDienThoai(sdt);

		roomService.updateRoomName(roomName,roomId);


		return "redirect:/group/"+roomId;
	}
	@PostMapping("/createRoom")
	public String createRoom(Model model, @RequestParam String roomName) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String sdt = auth.getName(); // get logged in username;
		AccountDTO accountLogin = accountService.getAccountBySoDienThoai(sdt);
		RoomDTO room = new RoomDTO();
		room.setName(roomName);
		room.setAdminId(accountLogin.getId());
		room.setType("Group");

		//CREATE NEW ROOM
		RoomDTO temp = roomService.createGroup(room);

		//ADD ADMIN INTO GROUP
		List<Long> listTemp = new ArrayList<>();
		listTemp.add(accountLogin.getId());
		roomService.addMembers(listTemp,temp.getId());

		return "redirect:/group/"+temp.getId();
	}
	@PostMapping("/deleteRoom")
	public String deleteRoom(Model model, @RequestParam long roomId) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String sdt = auth.getName(); // get logged in username;
		AccountDTO accountLogin = accountService.getAccountBySoDienThoai(sdt);
		roomService.deleteRoom(roomId);

		return "redirect:/group";
	}
	@PostMapping("/leaveRoom")
	public String leaveRoom(Model model, @RequestParam long roomId, @RequestParam long accountId) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String sdt = auth.getName(); // get logged in username;
		AccountDTO accountLogin = accountService.getAccountBySoDienThoai(sdt);

		roomService.leaveRoom(roomId,accountId);

		return "redirect:/group";
	}
}
