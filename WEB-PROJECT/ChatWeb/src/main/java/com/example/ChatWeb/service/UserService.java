package com.example.ChatWeb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.ChatWeb.dto.UserDTO;

@Service
public class UserService {

	private static final String LOCALHOST = "http://localhost:9000";

	@Autowired
	private RestTemplate restTemplate;

	public UserDTO getUserBySoDienThoai(String sdt) {
		UserDTO user = restTemplate.getForObject(LOCALHOST + "/api/users/bySoDienThoai/" + sdt, UserDTO.class);
		if (user == null)
			return new UserDTO();
		System.out.println(user);

		return user;
	}

	public String sendRegister( UserDTO user) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		final HttpEntity<UserDTO> request = new HttpEntity<>(user,headers);
		ResponseEntity<String> response = restTemplate.exchange(LOCALHOST+"/api/users", HttpMethod.POST, request, String.class);
		if (response.getStatusCode().equals(HttpStatus.OK)) {
			System.out.println("got response succsessfully");
		}
		return "";
	}

	
}
