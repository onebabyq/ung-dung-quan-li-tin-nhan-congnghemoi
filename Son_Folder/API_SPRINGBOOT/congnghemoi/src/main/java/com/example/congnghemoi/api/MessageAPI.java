package com.example.congnghemoi.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.congnghemoi.entity.Message;
import com.example.congnghemoi.service.MessageService;

@RestController
@RequestMapping(value = "/api")
public class MessageAPI {
	@Autowired
	private MessageService messageService;
	
	@GetMapping(value="/messages")
	public List<Message> getMessages() {
		
		return messageService.findAll();
	}
	
	@GetMapping(value="/messages/{id}")
	public Message getMessageById(@PathVariable long id) {
		
		return messageService.findById(id);
	}
	@GetMapping(value="/messagesWithAccount/{id}")
	public Message getMessageWithAccoutById(@PathVariable long id) {
		
		return messageService.findById(id);
	}
	@PostMapping(value="/messages")
	public Message saveMessage(@RequestBody Message newEntity) {
		
		return messageService.save(newEntity);
	}
	@PutMapping(value="/messages/{id}")
	public Message updateMessage(@RequestBody Message newEntity) {
		Message temp = messageService.findById(newEntity.getId());
		if(temp==null)
			return null;
		return messageService.save(newEntity);
	}
	@DeleteMapping(value="/messages/{id}")
	public String deleteMessage(@PathVariable long id) {
		messageService.deleteById(id);
		return "Deleted Message with id : "+id;
	}
}
