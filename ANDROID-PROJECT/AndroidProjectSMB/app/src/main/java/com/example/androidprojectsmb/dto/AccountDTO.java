package com.example.androidprojectsmb.dto;

import com.example.androidprojectsmb.dto.ContactDTO;
import com.example.androidprojectsmb.dto.MessageDTO;
import com.example.androidprojectsmb.dto.RoomDTO;
import com.example.androidprojectsmb.dto.UserDTO;

import java.util.ArrayList;
import java.util.List;


public class AccountDTO{

	private Long id;
	private String username;
	private String avatar;

	private List<ContactDTO> listContact = new ArrayList<>();


	private List<MessageDTO> messages = new ArrayList<>();


	private List<RoomDTO> rooms = new ArrayList<>();


	private UserDTO user;


	public AccountDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AccountDTO(Long id, String username, String avatar, List<ContactDTO> listContact, List<MessageDTO> messages,
					  List<RoomDTO> rooms, UserDTO user) {
		super();
		this.id = id;
		this.username = username;
		this.avatar = avatar;
		this.listContact = listContact;
		this.messages = messages;
		this.rooms = rooms;
		this.user = user;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public UserDTO getUser() {
		return user;
	}

	public void setUser(UserDTO user) {
		this.user = user;
	}



	public List<MessageDTO> getMessageDTOs() {
		return messages;
	}

	public void setMessageDTOs(List<MessageDTO> messages) {
		this.messages = messages;
	}

	public List<RoomDTO> getRoomDTOs() {
		return rooms;
	}

	public void setRoomDTOs(List<RoomDTO> rooms) {
		this.rooms = rooms;
	}






	public List<ContactDTO> getListContact() {
		return listContact;
	}

	public void setListContact(List<ContactDTO> listContact) {
		this.listContact = listContact;
	}

	public List<MessageDTO> getMessages() {
		return messages;
	}

	public void setMessages(List<MessageDTO> messages) {
		this.messages = messages;
	}

	public List<RoomDTO> getRooms() {
		return rooms;
	}

	public void setRooms(List<RoomDTO> rooms) {
		this.rooms = rooms;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	@Override
	public String toString() {
		return "AccountDTO [id=" + id + ", username=" + username + ", avatar=" + avatar + ", listContact=" + listContact
				+ ", messages=" + messages + ", rooms=" + rooms + ", user=" + user + "]";
	}




}
