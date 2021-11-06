package com.example.ChatWeb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.ChatWeb.dto.MessageDTO;
@Service
public class MessageService {

	private static final String LOCALHOST = "http://localhost:9000/api";

	@Autowired
	private RestTemplate restTemplate;

	

	public List<MessageDTO> getListMessageByMessageId(Long id) {
		ResponseEntity<List<MessageDTO>> responseEntity =
		        restTemplate.exchange(LOCALHOST+"/messages/byRoomId/"+id,
		            HttpMethod.GET, null, new ParameterizedTypeReference<List<MessageDTO>>() {
		            });
		List<MessageDTO> listMessage = responseEntity.getBody();

		return listMessage;
	}



	
}