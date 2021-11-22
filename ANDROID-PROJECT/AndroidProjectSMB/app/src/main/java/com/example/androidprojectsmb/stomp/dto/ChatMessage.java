package com.example.androidprojectsmb.stomp.dto;


public class ChatMessage {
    private long idSender;
    private MessageType type;
    private String content;
    private String fileName;
    private String contentType;
    private String sender;
    private long roomId;

    public enum MessageType {
        CHAT,
        JOIN,
        LEAVE,
        INVITE
    }





    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public long getRoomId() {
        return roomId;
    }

    public void setRoomId(long roomId) {
        this.roomId = roomId;
    }

    public MessageType getType() {
        return type;
    }

    public long getIdSender() {
        return idSender;
    }

    public void setIdSender(long idSender) {
        this.idSender = idSender;
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

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    @Override
    public String toString() {
        return "ChatMessage [idSender=" + idSender + ", type=" + type + ", content=" + content + ", fileName="
                + fileName + ", contentType=" + contentType + ", sender=" + sender + ", roomId=" + roomId + "]";
    }






}
