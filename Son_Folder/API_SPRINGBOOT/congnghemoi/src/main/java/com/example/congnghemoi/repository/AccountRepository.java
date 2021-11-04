package com.example.congnghemoi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.congnghemoi.entity.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long>{

}
