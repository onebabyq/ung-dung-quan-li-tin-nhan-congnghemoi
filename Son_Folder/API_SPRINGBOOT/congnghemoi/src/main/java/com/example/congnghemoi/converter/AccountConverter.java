package com.example.congnghemoi.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.ChatWeb.dto.RoleDTO;
import com.example.ChatWeb.dto.AccountDTO;
import com.example.congnghemoi.entity.Role;
import com.example.congnghemoi.entity.Account;



@Component
public class AccountConverter {
	public AccountDTO toDTO(Account entity) {
		AccountDTO result = new AccountDTO();
		result.setId(entity.getId());
		//result.setUser(entity.getUser());
		result.setAvatar(entity.getAvatar());
		result.setUsername(entity.getUsername());
		return result;
	}
	public Account toEntity(AccountDTO dto) {
		Account result = new Account();
		//result.setId(dto.getId());
		//result.setUser(dto.getUser());
		result.setAvatar(dto.getAvatar());
		result.setUsername(dto.getUsername());
		return result;
	}

}
