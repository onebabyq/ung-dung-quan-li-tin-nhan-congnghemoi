package com.example.ChatWeb.api;

import java.util.List;

import com.example.ChatWeb.dto.AccountDTO;
import com.example.ChatWeb.service.AccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.ChatWeb.dto.UserDTO;
import com.example.ChatWeb.service.UserService;

@RestController
@RequestMapping(value="/api/users")
public class UserAPI {
	@Autowired
	private UserService userService;
	@Autowired
	private AccountService accountService;
	public static final Logger log = LoggerFactory.getLogger(UserAPI.class);
	@GetMapping("/byContactOfAccountId/{id}/rooms/{roomId}")
	public List<UserDTO> getListContactByAccountId(@PathVariable long id,@PathVariable long roomId){
		List<UserDTO> listUser = userService.getUserByContactOfAccountId(id,roomId);
		
		return listUser;
	}
	//http://localhost:8080/api/users/43/rooms/48/byKey/o
	@GetMapping("/{id}/rooms/{roomId}/byKey/{key}")
	public List<UserDTO> getListContactByAccountId(@PathVariable long id,@PathVariable String key,@PathVariable long roomId){

		List<UserDTO> listUser = userService.getUserByKey(id,key,roomId);
		
		return listUser;
	}

}
