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

import com.example.congnghemoi.entity.Room;
import com.example.congnghemoi.service.RoomService;

@RestController
@RequestMapping(value = "/api")
public class RoomAPI {
	@Autowired
	private RoomService roomService;
	
	@GetMapping(value="/rooms")
	public List<Room> getRooms() {
		
		return roomService.findAll();
	}
	
	@GetMapping(value="/rooms/{id}")
	public Room getRoomById(@PathVariable long id) {
		
		return roomService.findById(id);
	}
	@GetMapping(value="/roomsWithAccount/{id}")
	public Room getRoomWithAccoutById(@PathVariable long id) {
		
		return roomService.findById(id);
	}
	@PostMapping(value="/rooms")
	public Room saveRoom(@RequestBody Room newEntity) {
		
		return roomService.save(newEntity);
	}
	@PutMapping(value="/rooms/{id}")
	public Room updateRoom(@RequestBody Room newEntity) {
		Room temp = roomService.findById(newEntity.getId());
		if(temp==null)
			return null;
		return roomService.save(newEntity);
	}
	@DeleteMapping(value="/rooms/{id}")
	public String deleteRoom(@PathVariable long id) {
		roomService.deleteById(id);
		return "Deleted Room with id : "+id;
	}
}
