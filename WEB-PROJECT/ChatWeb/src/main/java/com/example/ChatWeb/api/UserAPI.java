package com.example.ChatWeb.api;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ChatWeb.dto.UserDTO;
import com.example.ChatWeb.service.UserService;

@RestController
@RequestMapping(value="/api/users")
public class UserAPI {
	@Autowired
	private UserService userService;
	public static final Logger log = LoggerFactory.getLogger(UserAPI.class);
	@GetMapping("/byContactOfAccountId/{id}")
	public List<UserDTO> getListContactByAccountId(@PathVariable long id){
		List<UserDTO> listUser = userService.getUserByContactOfAccountId(id);
		
		return listUser;
	}
	@GetMapping("/byKey")
	public List<UserDTO> getListContactByAccountId(@RequestBody String key){
		List<UserDTO> listUser = userService.getUserByKey(key);
		
		return listUser;
	}
}
