package com.example.congnghemoi.service.impl;

import java.util.List;

import com.example.congnghemoi.entity.Account;
import com.example.congnghemoi.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.congnghemoi.entity.Room;
import com.example.congnghemoi.repository.RoomRepository;
import com.example.congnghemoi.service.RoomService;

@Service
public class RoomServiceImpl implements RoomService {
	@Autowired
	private RoomRepository roomRepository;
	@Autowired
	private MessageRepository messageRepository;
	@Override
	public List<Room> findAll() {
		// TODO Auto-generated method stub
		return roomRepository.findAll();
	}
	
	

	@Override
	public Room save(Room roomEntity) {
		// TODO Auto-generated method stub
		return roomRepository.save(roomEntity);
	}



	@Override
	public Room findById(long id) {
		// TODO Auto-generated method stub
		return roomRepository.findById(id).get();
	}



	@Override
	public void deleteById(long id) {
		// TODO Auto-generated method stub
		messageRepository.deleteByRoomId(id);
		roomRepository.deleteAllAccoutRoom(id);
		roomRepository.deleteById(id);
	}



	@Override
	public Room findRoomDualByTwoAccountId(long id1, long id2) {
		// TODO Auto-generated method stub
		return roomRepository.findRoomDualByTwoAccountId(id1,id2);
	}



	@Override
	public void insertAccoutRoom(long accId, long roomId) {
		// TODO Auto-generated method stub
		roomRepository.insertAccoutRoom(accId,roomId);
	}



	@Override
	public List<Room> findRoomByAccountId(long id) {
		// TODO Auto-generated method stub
		return roomRepository.findRoomByAccountId(id);
	}

	@Override
	public void addMembers(List<Long> listIdMember,long id) {
		for(long l : listIdMember){
			roomRepository.insertAccoutRoom(l,id);
		}
	}

	@Override
	public void removeMembers(List<Long> listIdMember, long id) {
		for(long l : listIdMember){
			roomRepository.deleteAccoutRoom(l,id);
		}
	}

	@Override
	public void leaveRoom(long idRoom, long idAccount) {
		roomRepository.deleteAccoutRoom(idAccount,idRoom);
	}


}
