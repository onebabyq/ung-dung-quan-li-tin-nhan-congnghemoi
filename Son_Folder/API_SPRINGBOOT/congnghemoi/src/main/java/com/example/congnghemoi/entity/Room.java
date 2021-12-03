package com.example.congnghemoi.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Room extends BaseEntity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5385951309781988012L;
	private String name;
    private int lastMessageId;
    private String type;
    @Column(columnDefinition = "boolean default false")
    private boolean deleted;
    private int adminId;
    
    @OneToMany(mappedBy = "room")
    @JsonManagedReference(value="room-message-movement")
    private List<Message> messages = new ArrayList<>();
   
    @ManyToMany(  mappedBy = "rooms")
    @JsonBackReference(value="room-account-movement")
    private List<Account> accounts = new ArrayList<>();
    
    
    
	public List<Message> getMessages() {
		return messages;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}

	

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

	public int getLastMessageId() {
        return lastMessageId;
    }

    public void setLastMessageId(int lastMessageId) {
        this.lastMessageId = lastMessageId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

  
}
