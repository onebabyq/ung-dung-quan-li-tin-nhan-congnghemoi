package com.example.congnghemoi.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="new")
public class NewEntity extends BaseEntity {
	private String title;
	private String thumbnail;
	private String shortDescription;
	private String content;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getThumbnail() {
		return thumbnail;
	}
	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}
	public String getShortDescription() {
		return shortDescription;
	}
	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
}
