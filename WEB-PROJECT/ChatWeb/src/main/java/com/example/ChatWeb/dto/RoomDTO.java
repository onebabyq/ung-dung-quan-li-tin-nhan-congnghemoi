package com.example.ChatWeb.dto;

import java.util.ArrayList;
import java.util.List;


public class RoomDTO  {
	private Long id;

    private int lastMessageId;
    private String type;
  
    private boolean deleted;
    private Long adminId;
    
    
   
    private List<MessageDTO> messages = new ArrayList<>();
   
  
    private List<AccountDTO> accounts = new ArrayList<>();
    
    
    
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<MessageDTO> getMessages() {
		return messages;
	}

	public void setMessages(List<MessageDTO> messages) {
		this.messages = messages;
	}

	

	public List<AccountDTO> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<AccountDTO> accounts) {
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

	public Long getAdminId() {
		return adminId;
	}

	public void setAdminId(Long adminId) {
		this.adminId = adminId;
	}

	@Override
	public String toString() {
		return "RoomDTO [id=" + id + ", lastMessageId=" + lastMessageId + ", type=" + type + ", deleted=" + deleted
				+ ", adminId=" + adminId + ", messages=" + messages + ", accounts=" + accounts + "]";
	}

   

  
}
