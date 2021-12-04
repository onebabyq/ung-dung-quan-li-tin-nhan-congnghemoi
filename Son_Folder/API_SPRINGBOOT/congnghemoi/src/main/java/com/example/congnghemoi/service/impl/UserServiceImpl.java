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



	@Override
	public List<User> findListUserByContactOfAccountId(long id,long roomId) {
		// TODO Auto-generated method stub
		return userRepository.getListUserByContactOfAccountIdNotInRoom(id,roomId);
	}
	@Override
	public List<User> findListUserByContactOfAccountId(long id) {
		// TODO Auto-generated method stub
		return userRepository.getListUserByContactOfAccountId(id);
	}



	@Override
	public List<User> findListUserByKey(long id,String key,long roomId) {
		// TODO Auto-generated method stub
		return userRepository.findListUserByKey(id,key,roomId);
	}

	@Override
	public User findByAccountId(long id) {
		return userRepository.findByAccountId(id);
	}

	@Override
	public List<User> findListUserByContactOfAccountIdNotAccept(long id) {
		return userRepository.findListUserByContactOfAccountIdNotAccept(id);
	}

	@Override
	public List<User> findListUserByContactOfAccountIdAccepted(long id) {
		return userRepository.findListUserByContactOfAccountIdAccepted(id);
	}


}
