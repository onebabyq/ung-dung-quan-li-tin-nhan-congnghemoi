package com.example.congnghemoi.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.ChatWeb.dto.RoleDTO;
import com.example.ChatWeb.dto.UserDTO;
import com.example.congnghemoi.entity.Role;
import com.example.congnghemoi.entity.User;



@Component
public class UserConverter {
	@Autowired
	AccountConverter accountConverter;
	public UserDTO toDTO(User entity) {
		UserDTO result = new UserDTO();
		result.setId(entity.getId());
		result.setSoDienThoai(entity.getSoDienThoai());
		result.setEnable(entity.isEnable());
		result.setPassword(entity.getPassword());
		result.setAccount(accountConverter.toDTO(entity.getAccount()));
		return result;
	}
	public User toEntity(UserDTO dto) {
		User result = new User();
		//result.setId(dto.getId());
		result.setSoDienThoai(dto.getSoDienThoai());
		result.setEnable(dto.isEnable());
		result.setPassword(dto.getPassword());
		result.setAccount(accountConverter.toEntity(dto.getAccount()));
		return result;
	}

}
