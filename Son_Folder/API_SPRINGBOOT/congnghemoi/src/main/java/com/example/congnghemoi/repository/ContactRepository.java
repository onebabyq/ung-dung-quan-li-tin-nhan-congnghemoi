package com.example.congnghemoi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.congnghemoi.entity.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long>{

	List<Contact> findByAccountId(long id);

}
