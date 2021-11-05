package com.example.congnghemoi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.congnghemoi.entity.Contact;
import com.example.congnghemoi.repository.ContactRepository;
import com.example.congnghemoi.service.ContactService;

@Service
public class ContactServiceImpl implements ContactService {
	@Autowired
	private ContactRepository contactRepository;
	
	@Override
	public List<Contact> findAll() {
		// TODO Auto-generated method stub
		return contactRepository.findAll();
	}

	

	@Override
	public Contact save(Contact contactEntity) {
		// TODO Auto-generated method stub
		return contactRepository.save(contactEntity);
	}



	@Override
	public Contact findById(long id) {
		// TODO Auto-generated method stub
		return contactRepository.findById(id).get();
	}



	@Override
	public void deleteById(long id) {
		// TODO Auto-generated method stub
		
		contactRepository.deleteById(id);
	}



	@Override
	public List<Contact> findByAccountId(long id) {
		// TODO Auto-generated method stub
		return contactRepository.findByAccountId(id);
	}




}
