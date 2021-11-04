package com.example.congnghemoi.service;

import java.util.List;

import com.example.congnghemoi.entity.Contact;



public interface ContactService {
	List<Contact> findAll();
	Contact findById(long id);
	Contact save(Contact contactEntity);
	void deleteById(long id);
	
}
