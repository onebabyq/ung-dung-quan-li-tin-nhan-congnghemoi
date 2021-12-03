package com.example.congnghemoi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.congnghemoi.entity.Account;
import com.example.congnghemoi.repository.AccountRepository;
import com.example.congnghemoi.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {
	@Autowired
	private AccountRepository accountRepository;
	
	@Override
	public List<Account> findAll() {
		// TODO Auto-generated method stub
		return accountRepository.findAll();
	}

	

	@Override
	public Account save(Account accountEntity) {
		// TODO Auto-generated method stub
		return accountRepository.save(accountEntity);
	}



	@Override
	public Account findById(long id) {
		// TODO Auto-generated method stub
		return accountRepository.findById(id).get();
	}



	@Override
	public void deleteById(long id) {
		// TODO Auto-generated method stub
		
		accountRepository.deleteById(id);
	}



	@Override
	public Account findAccountBySoDienThoai(long id) {
		// TODO Auto-generated method stub
		return accountRepository.findByAccountUserSoDienThoai(id).get();
	}

	@Override
	public List<Account> findListAccountInRoomById(long id) {
		return accountRepository.findListAccountInRoomById(id);
	}
	@Override
	public Account findAccountAdminByRoomId(long id) {
		return accountRepository.findAccountAdminByRoomId(id);
	}


}
