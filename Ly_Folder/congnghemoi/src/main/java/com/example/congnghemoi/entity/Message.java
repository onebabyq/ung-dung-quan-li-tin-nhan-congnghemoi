package com.example.congnghemoi.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Message extends BaseEntity implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4979900646312142703L;

	private String content;
	private String contentType;
	private String readStatus;
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonBackReference(value="room-message-movement")
	private Room room;
	@ManyToOne(fetch = FetchType.EAGER)
	//@JsonBackReference(value="message-account-movement")
	private Account from;
	
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
	public Room getRoom() {
		return room;
	}
	public void setRoom(Room room) {
		this.room = room;
	}
	public Account getFrom() {
		return from;
	}
	public void setFrom(Account from) {
		this.from = from;
	}
	/*
	 * @Override public String toString() { return "Message [content=" + content +
	 * ", contentType=" + contentType + ", readStatus=" + readStatus + ", room=" +
	 * room + ", from=" + from + "]"; }
	 */
}
