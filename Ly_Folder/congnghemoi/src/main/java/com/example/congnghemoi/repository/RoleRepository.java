package com.example.congnghemoi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.congnghemoi.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{

}
