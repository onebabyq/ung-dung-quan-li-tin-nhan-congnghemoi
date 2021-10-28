package com.example.cong_nghe_moi;

import java.util.List;

public class Account {
    private int id;
    private String username;
    private String avatar;
    private List<Contact> listFriend;

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

    public List<Contact> getListFriend() {
        return listFriend;
    }

    public void setListFriend(List<Contact> listFriend) {
        this.listFriend = listFriend;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", avatar='" + avatar + '\'' +
                ", listFriend=" + listFriend +
                '}';
    }
}
