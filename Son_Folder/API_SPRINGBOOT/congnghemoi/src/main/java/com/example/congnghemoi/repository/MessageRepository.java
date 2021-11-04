package com.example.congnghemoi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.congnghemoi.entity.Message;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long>{

}
