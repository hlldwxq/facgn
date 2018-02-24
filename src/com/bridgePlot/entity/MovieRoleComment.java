package com.bridgePlot.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity  //h
@Table(name="comment_role")
public class MovieRoleComment {
	private int id;
	private int user_id;
	private int role_id;
	private String content;
	private Date date;
	private int like;
	
	@Id
	@Column(name="id",nullable=false,unique=true)
	@GeneratedValue(strategy = GenerationType.IDENTITY) //h 
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name="user_id")
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	
	@Column(name="content")
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	@Column(name="date")
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	@Column(name="like_num")
	public int getLike() {
		return like;
	}
	public void setLike(int like) {
		this.like = like;
	}
	
	@Column(name="role_id")
	public int getRole_id() {
		return role_id;
	}
	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}
}
