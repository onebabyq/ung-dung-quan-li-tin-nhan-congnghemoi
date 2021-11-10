package com.example.appchat.DTO;

import java.util.ArrayList;
import java.util.List;

public class RoleDTO {
    private String id;
    private String roleName;
    private List<UserDTO> users = new ArrayList<>();





    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public List<UserDTO> getUsers() {
        return users;
    }
    public void setUsers(List<UserDTO> users) {
        this.users = users;
    }
    public String getRoleName() {
        return roleName;
    }
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
    //	public List<User> getUsers() {
//		return users;
//	}
//	public void setUsers(List<User> users) {
//		this.users = users;
//	}
    @Override
    public String toString() {
        return "Role [roleName=" + roleName + ", users=" + users + "]";
    }
}
