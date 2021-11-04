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

import com.example.congnghemoi.entity.Role;
import com.example.congnghemoi.service.RoleService;

@RestController
@RequestMapping(value = "/api")
public class RoleAPI {
	@Autowired
	private RoleService roleService;
	
	@GetMapping(value="/roles")
	public List<Role> getRoles() {
		
		return roleService.findAll();
	}
	
	@GetMapping(value="/roles/{id}")
	public Role getRoleById(@PathVariable long id) {
		
		return roleService.findById(id);
	}
	@GetMapping(value="/rolesWithAccount/{id}")
	public Role getRoleWithAccoutById(@PathVariable long id) {
		
		return roleService.findById(id);
	}
	@PostMapping(value="/roles")
	public Role saveRole(@RequestBody Role newEntity) {
		
		return roleService.save(newEntity);
	}
	@PutMapping(value="/roles/{id}")
	public Role updateRole(@RequestBody Role newEntity) {
		Role temp = roleService.findById(newEntity.getId());
		if(temp==null)
			return null;
		return roleService.save(newEntity);
	}
	@DeleteMapping(value="/roles/{id}")
	public String deleteRole(@PathVariable long id) {
		roleService.deleteById(id);
		return "Deleted Role with id : "+id;
	}
}
