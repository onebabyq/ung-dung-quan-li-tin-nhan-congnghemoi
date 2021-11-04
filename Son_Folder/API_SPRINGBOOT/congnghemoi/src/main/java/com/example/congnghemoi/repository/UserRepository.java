package com.example.congnghemoi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.example.congnghemoi.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
