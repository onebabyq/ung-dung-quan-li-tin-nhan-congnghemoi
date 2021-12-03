package com.example.congnghemoi.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.congnghemoi.entity.Account;

@Repository
public interface AccountRepository extends CrudRepository<Account, Long>{
	@Query(value="SELECT * FROM account ",nativeQuery = true)
	List<Account> findAll();
	
	//Optional<Account> findByAccountUserSoDienThoai(long id);
	@Query(value="SELECT a.* FROM account a JOIN user u ON a.id = u.account_id where u.so_dien_thoai = ?1",nativeQuery = true)
	Optional<Account> findByAccountUserSoDienThoai(long id);

	@Query(value="select a.* from account_room ar JOIN account a ON ar.account_id = a.id where ar.room_id = ?1",nativeQuery = true)
	List<Account> findListAccountInRoomById(long id);

	@Query(value="SELECT a.* FROM room r JOIN account a ON r.admin_id = a.id where r.id = ?1",nativeQuery = true)
	Account findAccountAdminByRoomId(long id);
}
