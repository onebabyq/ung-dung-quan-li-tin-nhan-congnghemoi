package com.example.congnghemoi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.congnghemoi.entity.Room;

@Repository
public interface RoomRepository extends CrudRepository<Room, Long>{
	@Query(value="SELECT * FROM room ",nativeQuery = true)
	List<Room> findAll();
	@Query(value="SELECT r.* FROM room r JOIN account_room ar ON r.id = ar.room_id where ar.account_id = ?1 AND  r.id in (SELECT r.id FROM room r JOIN account_room ar ON r.id = ar.room_id where ar.account_id =?2)",nativeQuery = true)
	Room findRoomDualByTwoAccountId(long id1, long id2);
	@Modifying
	@Query(value="INSERT INTO account_room (account_id, room_id) VALUES (?1, ?2);",nativeQuery = true)
	@Transactional
	void insertAccoutRoom(long accId, long roomId);

}
