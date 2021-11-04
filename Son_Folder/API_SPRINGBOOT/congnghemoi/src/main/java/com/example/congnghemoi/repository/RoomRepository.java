package com.example.congnghemoi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.congnghemoi.entity.Room;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long>{

}
