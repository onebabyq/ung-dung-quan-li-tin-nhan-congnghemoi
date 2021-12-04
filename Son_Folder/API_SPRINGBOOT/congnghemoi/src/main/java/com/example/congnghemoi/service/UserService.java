package com.example.congnghemoi.service;

import java.util.List;

import com.example.congnghemoi.entity.User;



public interface UserService {
	List<User> findAll();
	User findById(long id);
	User save(User userEntity);
	void deleteById(long id);
	User findBySoDienThoai(String sdt);
	List<User> findListUserByContactOfAccountId(long id);
	List<User> findListUserByContactOfAccountId(long id,long roomId);
	List<User> findListUserByKey(long id,String key,long roomId);


	User findByAccountId(long id);

	List<User> findListUserByContactOfAccountIdNotAccept(long id);

	List<User> findListUserByContactOfAccountIdAccepted(long id);
}
