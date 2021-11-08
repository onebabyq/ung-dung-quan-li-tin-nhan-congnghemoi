package com.example.ChatWeb.model;

public class InviteMessage {
	private long idSender;
	private String sender;
	private MessageType type;
	private String content;
	private String telReceiver;
	private long idReceiver;

	public enum MessageType {
		CHAT, JOIN, LEAVE, INVITE
	}
	
	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public long getIdSender() {
		return idSender;
	}

	public void setIdSender(long idSender) {
		this.idSender = idSender;
	}

	public MessageType getType() {
		return type;
	}

	public void setType(MessageType type) {
		this.type = type;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getTelReceiver() {
		return telReceiver;
	}

	public void setTelReceiver(String telReceiver) {
		this.telReceiver = telReceiver;
	}

	public long getIdReceiver() {
		return idReceiver;
	}

	public void setIdReceiver(long idReceiver) {
		this.idReceiver = idReceiver;
	}

	@Override
	public String toString() {
		return "InviteMessage [idSender=" + idSender + ", sender=" + sender + ", type=" + type + ", content=" + content
				+ ", telReceiver=" + telReceiver + ", idReceiver=" + idReceiver + "]";
	}

	
}
