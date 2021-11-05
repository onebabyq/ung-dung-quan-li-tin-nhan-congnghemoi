package com.example.congnghemoi.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.congnghemoi.entity.Account;
import com.example.congnghemoi.entity.Contact;
import com.example.congnghemoi.service.AccountService;
import com.example.congnghemoi.service.ContactService;

@RestController
@RequestMapping(value = "/api")
public class ContactAPI {
	
	@Autowired
	private ContactService contactService;
	@Autowired
	private AccountService accountService;
	
	@GetMapping(value="/contacts")
	public List<Contact> getContacts() {
		
		return contactService.findAll();
	}
	
	@GetMapping(value="/contacts/{id}")
	public Contact getContactById(@PathVariable long id) {
		
		return contactService.findById(id);
	}
	@GetMapping(value="/contacts/getListFriendByAccountId/{id}")
	public List<Account> getContactByAccountId(@PathVariable long id) {
		List<Contact> listContact = contactService.findByAccountId(id);
		List<Account> listAccount = new ArrayList<>();
		for(Contact c : listContact) {
			listAccount.add(accountService.findById(c.getFriendId()));
		}
		return listAccount;
	}
	@GetMapping(value="/contactsWithAccount/{id}")
	public Contact getContactWithAccoutById(@PathVariable long id) {
		
		return contactService.findById(id);
	}
	@PostMapping(value="/contacts")
	public Contact saveContact(@RequestBody Contact newEntity) {
		
		return contactService.save(newEntity);
	}
	@PutMapping(value="/contacts/{id}")
	public Contact updateContact(@RequestBody Contact newEntity) {
		Contact temp = contactService.findById(newEntity.getId());
		if(temp==null)
			return null;
		return contactService.save(newEntity);
	}
	@DeleteMapping(value="/contacts/{id}")
	public String deleteContact(@PathVariable long id) {
		contactService.deleteById(id);
		return "Deleted Contact with id : "+id;
	}
}
