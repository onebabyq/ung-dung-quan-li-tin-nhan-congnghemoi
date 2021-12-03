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

import com.example.ChatWeb.dto.RoomDTO;

@Service
public class RoomService {

	private static final String LOCALHOST = "http://localhost:9000/api";

	@Autowired
	private RestTemplate restTemplate;

	public RoomDTO getRoomDualByTwoAccountId(long id1, long id2) {
		RoomDTO room = restTemplate.getForObject(LOCALHOST + "/rooms/byTwoAccountId/" + id1+"/"+id2, RoomDTO.class);
		if (room == null)
			return new RoomDTO();
		//System.out.println(room);

		return room;
	}
	public List<RoomDTO> getListGroupByAccountId(long id) {
		ResponseEntity<List<RoomDTO>> responseEntity =
		        restTemplate.exchange(LOCALHOST+"/rooms/byAccountId/"+id,
		            HttpMethod.GET, null, new ParameterizedTypeReference<List<RoomDTO>>() {
		            });
		List<RoomDTO> listMessage = responseEntity.getBody();

		return listMessage;
	}

	public RoomDTO getRoomById(long id) {
		RoomDTO room = restTemplate.getForObject(LOCALHOST + "/rooms/"+id, RoomDTO.class);
		if (room == null)
			return new RoomDTO();
		//System.out.println(room);

		return room;
	}

	public RoomDTO createRoom( RoomDTO room,long accountId, long friendId) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		final HttpEntity<RoomDTO> request = new HttpEntity<>(room,headers);
		ResponseEntity<String> response = restTemplate.exchange(LOCALHOST+"/rooms/byTwoAccountId/"+accountId+"/"+friendId, HttpMethod.POST, request, String.class);
		if (response.getStatusCode().equals(HttpStatus.OK)) {
			System.out.println("Insert Room ByTwoAccountId Successfully!!!");
		}
		return room;
	}


	
}