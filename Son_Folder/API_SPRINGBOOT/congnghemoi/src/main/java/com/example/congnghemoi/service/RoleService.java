package com.example.congnghemoi.service;

import java.util.List;

import com.example.congnghemoi.entity.Role;



public interface RoleService {
	List<Role> findAll();
	Role findById(long id);
	Role save(Role roleEntity);
	void deleteById(long id);
	
}
