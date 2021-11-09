package com.example.appchat.DTO;


import java.util.ArrayList;
import java.util.List;

public class UserDTO {
    private Long id;
    private String soDienThoai;
    private String password;

    private boolean enable;

    private List<RoleDTO> roles = new ArrayList<>();

    private AccountDTO account;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public List<RoleDTO> getRoles() {
        return roles;
    }

    public void setRoles(List<RoleDTO> roles) {
        this.roles = roles;
    }

    public AccountDTO getAccount() {
        return account;
    }

    public void setAccount(AccountDTO account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return "User [soDienThoai=" + soDienThoai + ", password=" + password + ", enable=" + enable + ", roles="
                + ", account=" + "]";
    }
}
