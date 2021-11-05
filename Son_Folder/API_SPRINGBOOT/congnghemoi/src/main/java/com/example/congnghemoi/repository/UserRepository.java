package com.example.congnghemoi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.congnghemoi.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	Optional<User> findBySoDienThoai(String sdt);

}
