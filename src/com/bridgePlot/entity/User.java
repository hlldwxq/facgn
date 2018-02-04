package com.bridgePlot.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity  //h
@Table(name="user")  //h
public class User {
	 private Integer id; 
	 private String username;       
	 private String password;    
	 private String email;
	 private Date register_time;
	 private Date last_login_time;
	 private Integer edit_tick;
	 @Id
	 @Column(name="id",nullable=false,unique=true)
	 @GeneratedValue(strategy = GenerationType.IDENTITY) //h  
	 public Integer getId() {
		return id;
	 }
	 public void setId(Integer id) {
		this.id = id;
	 }
	 
	 @Column(name="username")
	 public String getUsername() {
		return username;
	 }
	 public void setUsername(String username) {
		this.username = username;
	 }
	 
	 @Column(name="password")
	 public String getPassword() {
		return password;
	 }
	 public void setPassword(String password) {
		this.password = password;
	 }
	 
	 @Column(name="email")
	 public String getEmail() {
		return email;
	 }
	 public void setEmail(String email) {
		this.email = email;
	 }
	 
	 @Column(name="register_time",updatable = false)
	 @Temporal(TemporalType.TIMESTAMP) 
	 @org.hibernate.annotations.Generated(org.hibernate.annotations.GenerationTime.INSERT)
	 public Date getRegister_time() {
		return register_time;
	 }
	 public void setRegister_time(Date register_time) {
		this.register_time = register_time;
	 }
	 @Column(name="last_login_time")
	 @org.hibernate.annotations.Generated(org.hibernate.annotations.GenerationTime.ALWAYS) 
	 @Temporal(TemporalType.TIMESTAMP)
	 public Date getLast_login_time() {
		return last_login_time;
	 }
	 public void setLast_login_time(Date last_login_time) {
		this.last_login_time = last_login_time;
	 }
	 @Column(name="edit_tick")
	 public Integer getEdit_tick() {
		return edit_tick;
	 }
	 public void setEdit_tick(Integer edit_tick) {
		this.edit_tick = edit_tick;
	 }
}
