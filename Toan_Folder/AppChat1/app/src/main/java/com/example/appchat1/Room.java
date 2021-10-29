package com.example.appchat1;

public class Room {
    private int id;
    private int lastMessageId;
    private String type;
    private boolean deleted;
    private int adminId;

    public int getId() {
        return id;
    }

    public int getLastMessageId() {
        return lastMessageId;
    }

    public String getType() {
        return type;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public int getAdminId() {
        return adminId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLastMessageId(int lastMessageId) {
        this.lastMessageId = lastMessageId;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", lastMessageId=" + lastMessageId +
                ", type='" + type + '\'' +
                ", deleted=" + deleted +
                ", adminId=" + adminId +
                '}';
    }
}
