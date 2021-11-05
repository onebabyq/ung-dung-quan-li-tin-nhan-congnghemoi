package com.example.android_finally;

public class Room {
    private int id;
    private int lastMessageId;
    private String type;
    private boolean deleted;
    private int adminId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
