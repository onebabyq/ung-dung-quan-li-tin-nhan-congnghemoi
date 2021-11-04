package com.example.congnghemoi.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity

public class User extends BaseEntity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2519190975415878665L;

	private String soDienThoai;
	private String password;
	@Column(columnDefinition = "boolean default true")
	private boolean enable;
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "user_role", joinColumns = {
			@JoinColumn(name = "user_id", referencedColumnName = "id") }, inverseJoinColumns = {
					@JoinColumn(name = "role_id", referencedColumnName = "id") })
	@JsonManagedReference
	private List<Role> roles = new ArrayList<>();
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "accountId", nullable = false, unique = true)
	@JsonManagedReference
	private Account account;
	
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
	
	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	@Override
	public String toString() {
		return "User [soDienThoai=" + soDienThoai + ", password=" + password + ", enable=" + enable + ", roles=" 
				+ ", account=" + "]";
	}

	
	
}
