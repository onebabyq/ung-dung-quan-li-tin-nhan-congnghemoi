package com.example.dangnhap;



public class User {
    private int id;
    private String soDienThoai;
    private String password;
    private boolean enable;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public User() {
    }
    public User(int id,String sdt,String password,boolean tt){
        this.id=id;
        this.soDienThoai=sdt;
        this.password=password;
        this.enable=tt;
    }
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", soDienThoai='" + soDienThoai + '\'' +
                ", password='" + password + '\'' +
                ", enable=" + enable +
                '}';
    }
}
