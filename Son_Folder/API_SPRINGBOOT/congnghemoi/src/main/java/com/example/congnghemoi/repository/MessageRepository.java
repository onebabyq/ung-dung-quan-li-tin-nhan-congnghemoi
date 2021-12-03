package com.example.congnghemoi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.congnghemoi.entity.Message;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface MessageRepository extends CrudRepository<Message, Long>{
	@Query(value="SELECT * FROM message ",nativeQuery = true)
	List<Message> findAll();
	@Query(value="SELECT m.* FROM message m JOIN room r ON m.room_id = r.id where r.id= ?1 ORDER BY m.create_date ",nativeQuery = true)
	List<Message> findMessageByRoomId(long id);
	@Modifying
	@Query(value="DELETE FROM message where room_id = ?1",nativeQuery = true)
	@Transactional
	void deleteByRoomId(long id);
}
