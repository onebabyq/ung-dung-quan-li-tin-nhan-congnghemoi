package com.example.ChatWeb.service.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.ChatWeb.dto.RoleDTO;
import com.example.ChatWeb.dto.UserDTO;
import com.example.ChatWeb.service.UserService;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	private UserService userService;

	@Override

	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserDTO user = userService.getUserBySoDienThoai(username);
		Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
		for (RoleDTO role : user.getRoles()) {
			grantedAuthorities.add(new SimpleGrantedAuthority(role.getRoleName()));
		}
		return new org.springframework.security.core.userdetails.User(user.getSoDienThoai(), user.getPassword(),
				grantedAuthorities);
	}
}