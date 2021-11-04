package com.example.congnghemoi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.congnghemoi.entity.Role;
import com.example.congnghemoi.repository.RoleRepository;
import com.example.congnghemoi.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {
	@Autowired
	private RoleRepository roleRepository;
	
	@Override
	public List<Role> findAll() {
		// TODO Auto-generated method stub
		return roleRepository.findAll();
	}

	

	@Override
	public Role save(Role roleEntity) {
		// TODO Auto-generated method stub
		return roleRepository.save(roleEntity);
	}



	@Override
	public Role findById(long id) {
		// TODO Auto-generated method stub
		return roleRepository.findById(id).get();
	}



	@Override
	public void deleteById(long id) {
		// TODO Auto-generated method stub
		
		roleRepository.deleteById(id);
	}




}
