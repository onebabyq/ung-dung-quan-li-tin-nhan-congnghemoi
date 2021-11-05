package com.example.ChatWeb.dto;

public class ContactDTO {
	private Long id;
    private AccountDTO friend;

	

    
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public AccountDTO getFriend() {
        return friend;
    }

    public void setFriend(AccountDTO friend) {
        this.friend = friend;
    }

}
