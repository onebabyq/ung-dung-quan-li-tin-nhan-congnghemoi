package com.example.congnghemoi.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
public class Account extends BaseEntity implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4402452958901200914L;

    private String username;
    private String avatar;
    @OneToMany(mappedBy = "friend")
    @JsonManagedReference(value="account-contact-movement")
	private List<Contact> listFriend = new ArrayList<>();
    
    @OneToMany(mappedBy = "from")
    @JsonBackReference(value="message-account-movement")
    private List<Message> messages = new ArrayList<>();
    
    @ManyToMany
    @JoinTable(name = "account_room",
            joinColumns = {
                    @JoinColumn(name = "account_id", referencedColumnName = "id")},
            inverseJoinColumns = {
                    @JoinColumn(name = "room_id", referencedColumnName = "id")})
   //@JsonManagedReference(value="room-account-movement")
   private List<Room> rooms = new ArrayList<>();
   // private List<Contact> listFriend;
    
    @OneToOne( cascade = CascadeType.ALL, mappedBy = "account")
    @JsonBackReference(value="user-account-movement")
    private User user;
    
    
    public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Contact> getListFriend() {
        return listFriend;
    }

    public List<Message> getMessages() {
		return messages;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}

	public List<Room> getRooms() {
		return rooms;
	}

	public void setRooms(List<Room> rooms) {
		this.rooms = rooms;
	}

	public void setListFriend(List<Contact> listFriend) {
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
