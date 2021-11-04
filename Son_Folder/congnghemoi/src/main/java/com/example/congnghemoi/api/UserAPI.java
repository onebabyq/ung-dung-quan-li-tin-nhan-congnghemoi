package com.example.congnghemoi.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.congnghemoi.entity.User;
import com.example.congnghemoi.service.UserService;

@RestController
@RequestMapping(value = "/api")
public class UserAPI {
	@Autowired
	private UserService userService;
	
	@GetMapping(value="/users")
	public List<User> getUsers() {
		List<User>  list = userService.findAll();
		for(User u : list) {
			System.out.println(u.toString());
			System.out.println(u.getAccount().toString());
		}
		return list;
	}
	
	@GetMapping(value="/users/{id}")
	public User getUserById(@PathVariable long id) {
		
		return userService.findById(id);
	}
	@GetMapping(value="/usersWithAccount/{id}")
	public User getUserWithAccoutById(@PathVariable long id) {
		
		return userService.findById(id);
	}
	@PostMapping(value="/users")
	public User saveUser(@RequestBody User newEntity) {
		
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
