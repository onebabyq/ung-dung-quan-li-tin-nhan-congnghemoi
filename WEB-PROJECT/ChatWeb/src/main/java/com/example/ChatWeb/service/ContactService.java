package com.example.ChatWeb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.ChatWeb.dto.AccountDTO;
import com.example.ChatWeb.dto.ContactDTO;
import com.example.ChatWeb.dto.MessageDTO;
import com.example.ChatWeb.dto.RoomDTO;
import com.example.ChatWeb.model.InviteMessage;
@Service
public class ContactService {

	private static final String LOCALHOST = "http://localhost:9000/api";

	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private AccountService accountService;


	
	public void createContact(ContactDTO contact) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		final HttpEntity<ContactDTO> request = new HttpEntity<>(contact,headers);
		ResponseEntity<String> response = restTemplate.exchange(LOCALHOST+"/contacts", HttpMethod.POST, request, String.class);
		if (response.getStatusCode().equals(HttpStatus.OK)) {
			System.out.println("Insert Contact Successfully!!!");
		}
	}
	public void updateAcceptContact(long accountId,long friendId) {
		restTemplate.getForObject(LOCALHOST + "/contacts/accept/"+accountId+"/"+friendId, String.class);
		
	}
	public void createByInviteMessage(InviteMessage inviteMessage) {
//		ContactDTO contact = new ContactDTO();
//		contact.setAccount(accountService.getAccountById(inviteMessage.getIdSender()));
//		contact.setAccept(false);
//		contact.setFriendId(inviteMessage.getIdReceiver());
		ContactDTO contact1 = new ContactDTO();
		contact1.setAccount(accountService.getAccountById(inviteMessage.getIdReceiver()));
		contact1.setAccept(false);
		contact1.setFriendId(inviteMessage.getIdSender());
		//createContact(contact);
		createContact(contact1);
	}

	public List<ContactDTO> getListContactByAccountId(Long id) {
		String url = LOCALHOST+"/contacts/getListContactByAccountId/"+id;
		ResponseEntity<List<ContactDTO>> responseEntity =
		        restTemplate.exchange(url,
		            HttpMethod.GET, null, new ParameterizedTypeReference<List<ContactDTO>>() {
		            });
		List<ContactDTO> listContact = responseEntity.getBody();

		return listContact;
	}
	
}