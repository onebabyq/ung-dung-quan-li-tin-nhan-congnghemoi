package com.example.congnghemoi.api;

import java.util.List;

import com.example.congnghemoi.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.congnghemoi.entity.Account;
import com.example.congnghemoi.service.AccountService;

@RestController
@RequestMapping(value = "/api")
public class AccountAPI {
	@Autowired
	private AccountService accountService;
	
	@GetMapping(value="/accounts")
	public List<Account> getAccounts() {
		
		return accountService.findAll();
	}
	
	@GetMapping(value="/accounts/{id}")
	public Account getAccountById(@PathVariable long id) {
		
		return accountService.findById(id);
	}
	@GetMapping(value="/accounts/bySoDienThoai/{id}")
	public Account getAccountBySoDienThoai(@PathVariable long id) {
		
		return accountService.findAccountBySoDienThoai(id);
	}

	@GetMapping(value="/accountsWithAccount/{id}")
	public Account getAccountWithAccoutById(@PathVariable long id) {
		
		return accountService.findById(id);
	}
	@GetMapping(value="/rooms/{id}/getAdmin")
	public ResponseEntity<Account> getAdmin(@PathVariable long id) {

		return ResponseEntity.ok(accountService.findAccountAdminByRoomId(id));
	}
	@GetMapping(value="/accounts/rooms/{id}")
	public ResponseEntity<List<Account>> getListAccountInRoomById(@PathVariable long id) {
		//System.out.println("id query: "+id);
		return ResponseEntity.ok(accountService.findListAccountInRoomById(id));
	}
	@PostMapping(value="/accounts")
	public Account saveAccount(@RequestBody Account newEntity) {
		
		return accountService.save(newEntity);
	}
	@PutMapping(value="/accounts/{id}")
	public Account updateAccount(@RequestBody Account newEntity) {
		Account temp = accountService.findById(newEntity.getId());
		if(temp==null)
			return null;
		return accountService.save(newEntity);
	}
	@DeleteMapping(value="/accounts/{id}")
	public String deleteAccount(@PathVariable long id) {
		accountService.deleteById(id);
		return "Deleted Account with id : "+id;
	}
}
