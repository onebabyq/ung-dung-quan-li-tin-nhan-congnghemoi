package com.example.appchat.DTO;

import java.util.List;

public class Account {
    private int id;
    private String username;
    private String avatar;
    private List<Account_Room> listAccountRoom;
    private List<Contact> listFriend;


    public List<Contact> getListFriend() {
        return listFriend;
    }

    public void setListFriend(List<Contact> listFriend) {
        this.listFriend = listFriend;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public List<Account_Room> getListAccountRoom() {
        return listAccountRoom;
    }

    public void setListAccountRoom(List<Account_Room> listAccountRoom) {
        this.listAccountRoom = listAccountRoom;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", avatar='" + avatar + '\'' +
                ", listAccountRoom=" + listAccountRoom +
                ", listFriend=" + listFriend +
                '}';
    }
}
