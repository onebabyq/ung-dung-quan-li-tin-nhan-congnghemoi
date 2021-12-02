package com.example.androidprojectsmb.dto;

public class ContactDTO  {
	private Long id;
	private AccountDTO account;
	private boolean accept;
	private long friendId;

	private AccountDTO friend;

	public AccountDTO getFriend() {
		return friend;
	}

	public void setFriend(AccountDTO friend) {
		this.friend = friend;
	}

	public AccountDTO getAccount() {
		return account;
	}

	public void setAccount(AccountDTO account) {
		this.account = account;
	}

	public boolean isAccept() {
		return accept;
	}

	public void setAccept(boolean accept) {
		this.accept = accept;
	}

	public long getFriendId() {
		return friendId;
	}

	public void setFriendId(long friendId) {
		this.friendId = friendId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "ContactDTO [id=" + id + ", account=" + account + ", accept=" + accept + ", friendId=" + friendId
				+ ", friend=" + friend + "]";
	}



}
