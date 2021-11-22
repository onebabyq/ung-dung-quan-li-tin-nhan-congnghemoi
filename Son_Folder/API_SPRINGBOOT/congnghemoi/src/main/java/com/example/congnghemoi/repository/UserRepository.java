package com.example.congnghemoi.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.congnghemoi.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{
	@Query(value="SELECT * FROM user ",nativeQuery = true)
	List<User> findAll();
	
	Optional<User> findBySoDienThoai(String sdt);
	
	@Query(value="select u.* from contact c JOIN account a ON c.account_id = a.id JOIN account a2 ON c.friend_id=a2.id JOIN user u ON u.account_id = a2.id WHERE a.id=?1 ",nativeQuery = true)
	List<User> getListUserByContactOfAccountId(long id);

}
