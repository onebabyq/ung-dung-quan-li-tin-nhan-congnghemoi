package com.example.congnghemoi.service;

import java.util.List;

import com.example.congnghemoi.entity.Account;



public interface AccountService {
	List<Account> findAll();
	Account findById(long id);
	Account save(Account accountEntity);
	void deleteById(long id);
	Account findAccountBySoDienThoai(long id);
	
}
