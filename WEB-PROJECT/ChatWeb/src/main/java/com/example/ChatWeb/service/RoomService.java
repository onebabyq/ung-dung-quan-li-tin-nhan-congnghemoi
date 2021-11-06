package com.example.ChatWeb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.ChatWeb.dto.AccountDTO;
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
		System.out.println(room);

		return room;
	}





	
}