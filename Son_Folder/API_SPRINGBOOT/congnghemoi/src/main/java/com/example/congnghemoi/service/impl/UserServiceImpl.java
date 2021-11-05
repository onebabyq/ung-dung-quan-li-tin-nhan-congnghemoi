package com.example.congnghemoi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.congnghemoi.entity.User;
import com.example.congnghemoi.repository.UserRepository;
import com.example.congnghemoi.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	

	@Override
	public User save(User userEntity) {
		// TODO Auto-generated method stub
		return userRepository.save(userEntity);
	}



	@Override
	public User findById(long id) {
		// TODO Auto-generated method stub
		return userRepository.findById(id).get();
	}



	@Override
	public void deleteById(long id) {
		// TODO Auto-generated method stub
		
		userRepository.deleteById(id);
	}



	@Override
	public User findBySoDienThoai(String sdt) {
		// TODO Auto-generated method stub
		return userRepository.findBySoDienThoai(sdt).get();
	}




}
