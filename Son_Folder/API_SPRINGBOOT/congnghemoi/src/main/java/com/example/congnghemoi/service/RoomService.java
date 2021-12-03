package com.example.congnghemoi.service;

import java.util.List;

import com.example.congnghemoi.entity.Account;
import com.example.congnghemoi.entity.Room;



public interface RoomService {
	List<Room> findAll();
	Room findById(long id);
	Room save(Room roomEntity);
	void deleteById(long id);
	Room findRoomDualByTwoAccountId(long id1, long id2);
	void insertAccoutRoom(long accId,long roomId);
	List<Room> findRoomByAccountId(long id);

    void addMembers(List<Long> listIdMember,long id);

	void removeMembers(List<Long> listIdMember, long id);

	void leaveRoom(long idRoom,long idAccount);


}
