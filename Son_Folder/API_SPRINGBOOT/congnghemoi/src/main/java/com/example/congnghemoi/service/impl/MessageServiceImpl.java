package com.example.congnghemoi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.congnghemoi.entity.Message;
import com.example.congnghemoi.repository.MessageRepository;
import com.example.congnghemoi.service.MessageService;

@Service
public class MessageServiceImpl implements MessageService {
	@Autowired
	private MessageRepository messageRepository;
	
	@Override
	public List<Message> findAll() {
		// TODO Auto-generated method stub
		return messageRepository.findAll();
	}

	

	@Override
	public Message save(Message messageEntity) {
		// TODO Auto-generated method stub
		return messageRepository.save(messageEntity);
	}



	@Override
	public Message findById(long id) {
		// TODO Auto-generated method stub
		return messageRepository.findById(id).get();
	}



	@Override
	public void deleteById(long id) {
		// TODO Auto-generated method stub
		
		messageRepository.deleteById(id);
	}



	@Override
	public List<Message> findMessageByRoomId(long id) {
		// TODO Auto-generated method stub
		return messageRepository.findMessageByRoomId(id);
	}




}
