package com.example.congnghemoi.api;

import java.util.List;

import com.example.ChatWeb.dto.AccountDTO;
import com.example.congnghemoi.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
	@GetMapping(value="/rooms/byTwoAccountId/{id1}/{id2}")
	public Room getRoomDualByTwoAccountId(@PathVariable long id1,@PathVariable long id2) {
		
		return roomService.findRoomDualByTwoAccountId(id1,id2);
	}
	
	@GetMapping(value="/rooms/byAccountId/{id}")
	public ResponseEntity<List<Room>> getRoomDualByAccountId(@PathVariable long id) {
		
		return ResponseEntity.ok(roomService.findRoomByAccountId(id));
	}

	@PostMapping(value="/rooms")
	public Room saveRoom(@RequestBody Room newEntity) {
		Room room =  roomService.save(newEntity);
		return room;
	}
	@PostMapping(value="/rooms/{id}/addMembers")
	public void addMembers(@RequestBody List<Long> listIdMember,@PathVariable long id) {
		roomService.addMembers(listIdMember,id);
	}
	@PostMapping(value="/rooms/{id}/removeMembers")
	public void removeMembers(@RequestBody List<Long> listIdMember,@PathVariable long id) {
		roomService.removeMembers(listIdMember,id);
	}
	@PostMapping(value="/rooms/byTwoAccountId/{accountId}/{friendId}")
	public Room saveRoomTwoAccountId(@RequestBody Room newEntity,@PathVariable long accountId,@PathVariable long friendId) {
		Room room =  roomService.save(newEntity);
		roomService.insertAccoutRoom(accountId, room.getId());
		roomService.insertAccoutRoom(friendId, room.getId());
		return room;
	}
	@PutMapping(value="/rooms/{id}")
	public Room updateRoom(@RequestBody Room newEntity) {
		Room temp = roomService.findById(newEntity.getId());
		if(temp==null)
			return null;
		return roomService.save(newEntity);
	}
	@PutMapping(value="/rooms/{id}/updateRoomName")
	public Room updateRoomName(@RequestBody String roomName,@PathVariable long id) {
		Room temp = roomService.findById(id);
		if(temp==null)
			return null;
		temp.setName(roomName);
		return roomService.save(temp);
	}
	@DeleteMapping(value="/rooms/{id}")
	public String deleteRoom(@PathVariable long id) {
		roomService.deleteById(id);
		return "Deleted Room with id : "+id;
	}
	@DeleteMapping(value="/rooms/{id}/leave")
	public String leaveRoom(@PathVariable long id,@RequestBody Long idAccount) {
		roomService.leaveRoom(id,idAccount);
		return "Leave success : "+id;
	}
	@DeleteMapping(value="/rooms/{id}/leave/{idAccount}")
	public String leaveRoom2(@PathVariable long id,@PathVariable long idAccount) {
		roomService.leaveRoom(id,idAccount);
		return "Leave success : "+id;
	}

}
