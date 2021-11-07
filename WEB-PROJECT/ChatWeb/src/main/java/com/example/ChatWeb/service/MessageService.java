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
import com.example.ChatWeb.model.ChatMessage;
@Service
public class MessageService {

	private static final String LOCALHOST = "http://localhost:9000/api";

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private AccountService accountService;
	@Autowired
	private RoomService roomService;

	public List<MessageDTO> getListMessageByMessageId(Long id) {
		ResponseEntity<List<MessageDTO>> responseEntity =
		        restTemplate.exchange(LOCALHOST+"/messages/byRoomId/"+id,
		            HttpMethod.GET, null, new ParameterizedTypeReference<List<MessageDTO>>() {
		            });
		List<MessageDTO> listMessage = responseEntity.getBody();

		return listMessage;
	}
	
	public MessageDTO createMessage( MessageDTO message) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		final HttpEntity<MessageDTO> request = new HttpEntity<>(message,headers);
		ResponseEntity<String> response = restTemplate.exchange(LOCALHOST+"/messages", HttpMethod.POST, request, String.class);
		if (response.getStatusCode().equals(HttpStatus.OK)) {
			System.out.println("Insert Message Successfully!!!");
		}
		return message;
	}
	public void createByChatMessage( ChatMessage chatmessage) {
		MessageDTO message = new MessageDTO();
		message.setContent(chatmessage.getContent());
		message.setFrom(accountService.getAccountById(chatmessage.getIdSender()));
		message.setContentType(chatmessage.getContentType());
		message.setReadStatus("Đã xem");
		message.setRoom(roomService.getRoomById(chatmessage.getRoomId()));
		message = createMessage( message);
	}

	
}