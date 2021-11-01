package com.example.congnghemoi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.congnghemoi.entity.NewEntity;
import com.example.congnghemoi.repository.NewRepository;
import com.example.congnghemoi.service.NewService;

@Service
public class NewServiceImpl implements NewService {
	@Autowired
	private NewRepository newRepository;
	
	@Override
	public List<NewEntity> findAll() {
		// TODO Auto-generated method stub
		return newRepository.findAll();
	}

	

	@Override
	public NewEntity save(NewEntity newEntity) {
		// TODO Auto-generated method stub
		return newRepository.save(newEntity);
	}



	@Override
	public NewEntity findById(long id) {
		// TODO Auto-generated method stub
		return newRepository.findById(id);
	}



	@Override
	public void deleteById(long id) {
		// TODO Auto-generated method stub
		
		newRepository.deleteById(id);
	}

}
