package com.example.congnghemoi.service;

import java.util.List;

import com.example.congnghemoi.entity.Room;



public interface RoomService {
	List<Room> findAll();
	Room findById(long id);
	Room save(Room roomEntity);
	void deleteById(long id);
	
}
