package com.example.congnghemoi.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.congnghemoi.entity.Account;
import com.example.congnghemoi.entity.User;
import com.example.congnghemoi.service.AccountService;
import com.example.congnghemoi.service.UserService;

@RestController
@RequestMapping(value = "/api")
public class UserAPI {
	@Autowired
	private UserService userService;
	@Autowired
	private AccountService accountService;

	
	
	@GetMapping(value="/users")
	public List<User> getUsers() {
		List<User>  list = userService.findAll();
		
		return list;
	}
	
	@GetMapping(value="/users/{id}")
	public User getUserById(@PathVariable long id) {
		
		return userService.findById(id);
	}
	@GetMapping(value="/users/accounts/{id}")
	public User getUserByAccountId(@PathVariable long id) {

		return userService.findByAccountId(id);
	}
	@GetMapping(value="/users/bySoDienThoai/{sdt}")
	public User getUserBySoDienThoai(@PathVariable String sdt) {
		//System.out.println("SĐT query: "+sdt);
		return userService.findBySoDienThoai(sdt);
	}

	@GetMapping(value="/users/byContactOfAccountId/{id}")
	public List<User> getListUserByContactOfAccountId(@PathVariable long id) {
		//System.out.println("SĐT query: "+sdt);
		return userService.findListUserByContactOfAccountId(id);
	}
	@GetMapping(value="/users/byContactOfAccountIdAccepted/{id}")
	public List<User> getListUserByContactOfAccountIdAccepted(@PathVariable long id) {
		//System.out.println("SĐT query: "+sdt);
		return userService.findListUserByContactOfAccountIdAccepted(id);
	}
	@GetMapping(value="/users/byContactOfAccountIdNotAccept/{id}")
	public List<User> getListUserByContactOfAccountIdNotAccept(@PathVariable long id) {
		//System.out.println("SĐT query: "+sdt);
		return userService.findListUserByContactOfAccountIdNotAccept(id);
	}
	@GetMapping(value="/users/byContactOfAccountId/{id}/rooms/{roomId}")
	public List<User> getListUserByContactOfAccountId(@PathVariable long id,@PathVariable long roomId) {
		//System.out.println("SĐT query: "+sdt);
		return userService.findListUserByContactOfAccountId(id,roomId);
	}

	@GetMapping(value="/users/{id}/rooms/{roomId}/byKey/{key}")
	public List<User> getListUserByContactOfAccountId(@PathVariable long id,@PathVariable String key,@PathVariable long roomId) {
		System.out.println("id: "+id);
		System.out.println("key: "+key);
		System.out.println("roomId: "+roomId);
		//System.out.println("id query: "+id);
		return userService.findListUserByKey(id,key,roomId);
	}

	@PostMapping(value="/users")
	public User saveUser(@RequestBody User newEntity) {
		Account temp = new Account();
		temp.setUsername(newEntity.getAccount().getUsername());
		Account account = accountService.save(temp);
		newEntity.setAccount(account);
		return userService.save(newEntity);
	}
	@PutMapping(value="/users/{id}")
	public User updateUser(@RequestBody User newEntity) {
		User temp = userService.findById(newEntity.getId());
		if(temp==null)
			return null;
		return userService.save(newEntity);
	}
	@DeleteMapping(value="/users/{id}")
	public String deleteUser(@PathVariable long id) {
		userService.deleteById(id);
		return "Deleted User with id : "+id;
	}
}
