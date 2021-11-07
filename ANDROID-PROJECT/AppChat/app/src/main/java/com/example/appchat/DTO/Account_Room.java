package com.example.appchat.DTO;

public class Account_Room {
    private int accountId;
    private String permission;
    private Room room;

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    @Override
    public String toString() {
        return "Account_Room{" +
                "accountId=" + accountId +
                ", permission='" + permission + '\'' +
                ", room=" + room +
                '}';
    }
}
