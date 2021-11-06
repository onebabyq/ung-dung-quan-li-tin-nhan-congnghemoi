package com.example.congnghemoi.service;

import java.util.List;

import com.example.congnghemoi.entity.Message;



public interface MessageService {
	List<Message> findAll();
	Message findById(long id);
	Message save(Message messageEntity);
	void deleteById(long id);
	List<Message> findMessageByRoomId(long id);
	
}
