package com.example.congnghemoi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.congnghemoi.entity.Contact;

@Repository
public interface ContactRepository extends CrudRepository<Contact, Long>{
	@Query(value="SELECT * FROM contact ",nativeQuery = true)
	List<Contact> findAll();
	
	@Query(value="SELECT c.* FROM contact c JOIN account a ON c.account_id=a.id WHERE a.id = ?1 ORDER BY c.accept",nativeQuery = true)
	List<Contact> findByAccountId(long id);

}
