package com.example.ChatWeb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.ChatWeb.dto.UserDTO;

@Service
public class UserService {
	
	private static final String LOCALHOST = "http://localhost:9000";
	
	@Autowired
	private RestTemplate restTemplate;
	
	public UserDTO getUserBySoDienThoai(String sdt) {
        UserDTO user =
                restTemplate.getForObject(LOCALHOST+"/api/users/bySoDienThoai/"
                                + sdt,
                        UserDTO.class);
        if(user==null)
        	return new UserDTO();
        System.out.println(user);

        return user;
    }
}
