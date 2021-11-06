package com.example.ChatWeb.dto;

import java.util.Date;

public class MessageDTO implements Comparable<MessageDTO> {

	private Long id;
	private String content;
	private String contentType;
	private String readStatus;

	private Date createDate;

	private RoomDTO room;

	private AccountDTO from;

	@Override
	public int compareTo(MessageDTO o) {
		return getCreateDate().compareTo(o.getCreateDate());
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public AccountDTO getFrom() {
		return from;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setFrom(AccountDTO from) {
		this.from = from;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public String getReadStatus() {
		return readStatus;
	}

	public void setReadStatus(String readStatus) {
		this.readStatus = readStatus;
	}

	public RoomDTO getRoom() {
		return room;
	}

	public void setRoom(RoomDTO room) {
		this.room = room;
	}

	@Override
	public String toString() {
		return "MessageDTO [id=" + id + ", content=" + content + ", contentType=" + contentType + ", readStatus="
				+ readStatus + ", createDate=" + createDate + ", room=" + room + ", from=" + from + "]";
	}

}
