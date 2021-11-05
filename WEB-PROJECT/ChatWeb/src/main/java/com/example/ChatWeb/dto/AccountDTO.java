package com.example.ChatWeb.dto;

import java.util.ArrayList;
import java.util.List;


public class AccountDTO{
	
	private Long id;
    private String username;
    private String avatar;

	private List<ContactDTO> listFriend = new ArrayList<>();
    
 
    private List<MessageDTO> messages = new ArrayList<>();
    

   private List<RoomDTO> rooms = new ArrayList<>();


    private UserDTO user;
    
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

	public List<ContactDTO> getListFriend() {
        return listFriend;
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

	public void setListFriend(List<ContactDTO> listFriend) {
        this.listFriend = listFriend;
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
		return "Account [username=" + username + ", avatar=" + avatar + ", listFriend=" + listFriend + ", messages="
				+ messages + ", rooms=" + rooms + ", user=" + user + "]";
	}
    

 
}
