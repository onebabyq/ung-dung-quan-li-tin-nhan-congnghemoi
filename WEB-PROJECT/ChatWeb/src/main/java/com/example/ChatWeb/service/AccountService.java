package com.example.ChatWeb.service;

import java.util.List;

import com.example.ChatWeb.dto.UserDTO;
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
@Service
public class AccountService {

	public static final String LOCALHOST = "http://ec2-54-169-112-210.ap-southeast-1.compute.amazonaws.com:9000/api";

	@Autowired
	private RestTemplate restTemplate;

	public AccountDTO getAccountBySoDienThoai(String sdt) {
		AccountDTO account = restTemplate.getForObject(LOCALHOST + "/accounts/bySoDienThoai/" + sdt, AccountDTO.class);
		if (account == null)
			return new AccountDTO();
		//System.out.println(account);

		return account;
	}
	public AccountDTO getAccountById(long id) {
		AccountDTO account = restTemplate.getForObject(LOCALHOST + "/accounts/" + id, AccountDTO.class);
		if (account == null)
			return new AccountDTO();
		//System.out.println(account);

		return account;
	}

	public List<AccountDTO> getListFriendByAccountId(Long id) {
		ResponseEntity<List<AccountDTO>> responseEntity =
		        restTemplate.exchange(LOCALHOST+"/contacts/getListFriendByAccountId/"+id,
		            HttpMethod.GET, null, new ParameterizedTypeReference<List<AccountDTO>>() {
		            });
		List<AccountDTO> listFriend = responseEntity.getBody();

		return listFriend;
	}
	public List<AccountDTO> getListAccountInRoomById(long id) {
		ResponseEntity<List<AccountDTO>> responseEntity = restTemplate.exchange(
				LOCALHOST + "/accounts/rooms/" + id, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<AccountDTO>>() {
				});
		List<AccountDTO> listAccountDTO = responseEntity.getBody();

		return listAccountDTO;
	}


	public AccountDTO getAdminInRoomById(long id) {
		String url = LOCALHOST + "/rooms/"+id+"/getAdmin";
		ResponseEntity<AccountDTO> responseEntity = restTemplate.exchange(
				url, HttpMethod.GET, null,
				new ParameterizedTypeReference<AccountDTO>() {
				});
		AccountDTO dto = responseEntity.getBody();

		return dto;
	}
}