package com.example.congnghemoi.entity;

import java.util.Date;

import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Date createDate;
	private Date modifiedDate;
	private String createBy;
	private String modifiedBy;
	public Long getId() {
		return id;
	}
	@CreatedDate
	public Date getCreateDate() {
		return createDate;
	}
	@LastModifiedDate
	public Date getModifiedDate() {
		return modifiedDate;
	}
	@CreatedBy
	public String getCreateBy() {
		return createBy;
	}
	@LastModifiedBy
	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	@Override
	public String toString() {
		return "BaseEntity{" +
				"id=" + id +
				", createDate=" + createDate +
				", modifiedDate=" + modifiedDate +
				", createBy='" + createBy + '\'' +
				", modifiedBy='" + modifiedBy + '\'' +
				'}';
	}
}
