package com.example.congnghemoi.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Role extends BaseEntity implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5037263163233097819L;

	private String roleName;
	@ManyToMany(  mappedBy = "roles",fetch = FetchType.LAZY)
	@JsonBackReference(value="user-role-movement")
    private List<User> users = new ArrayList<>();
	

	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
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
