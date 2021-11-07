package com.example.congnghemoi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.congnghemoi.entity.Contact;

@Repository
public interface ContactRepository extends CrudRepository<Contact, Long>{
	@Query(value="SELECT * FROM contact ",nativeQuery = true)
	List<Contact> findAll();
	
	@Query(value="SELECT c.* FROM contact c JOIN account a ON c.account_id=a.id WHERE a.id = ?1 ORDER BY c.accept",nativeQuery = true)
	List<Contact> findByAccountId(long id);
	@Modifying
	@Query(value="UPDATE `contact` SET `accept` = '1' WHERE `account_id` = ?1 and `friend_id` = ?2 ;",nativeQuery = true)
	@Transactional
	void updateContactByTwoId(Long accountId, Long friendId);

}
