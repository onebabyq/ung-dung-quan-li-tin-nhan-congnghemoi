package com.example.congnghemoi.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Contact extends BaseEntity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4806674609804322567L;
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonBackReference(value="account-contact-movement")
    private Account friend;

	

    public Account getFriend() {
        return friend;
    }

    public void setFriend(Account friend) {
        this.friend = friend;
    }

}
