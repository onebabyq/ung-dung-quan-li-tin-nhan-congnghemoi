package com.example.congnghemoi.service;

import java.util.List;

import com.example.congnghemoi.entity.NewEntity;

public interface NewService {
	List<NewEntity> findAll();
	NewEntity findById(long id);
	NewEntity save(NewEntity newEntity);
	void deleteById(long id);
}
