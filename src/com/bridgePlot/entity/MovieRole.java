package com.bridgePlot.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity  //h
@Table(name="movie_role")  //h
public class MovieRole {
	private int id;
	private int absolute_id;
	private String role_name;
	private String actor;
	private String role_sex;
	private String role_age;
	private String role_race;
	private String role_country;
	private String role_profession;
	private String label;
	private String role_introduction;
	private int movie_id;
	private String role_at_movie;
	private String role_pic;
	private int author_id;
	private String author;
	private Date edit_time;
	private int edit_tick;
	
	
	@Id
	@Column(name="id",nullable=false,unique=true)
	@GeneratedValue(strategy = GenerationType.IDENTITY) //h  
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name="author_id")
	public int getAuthor_id() {
		return author_id;
	}
	public void setAuthor_id(int author_id) {
		this.author_id = author_id;
	}
	
	@Column(name="author")
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	
	@Column(name="edit_time")
	public Date getEdit_time() {
		return edit_time;
	}
	public void setEdit_time(Date edit_time) {
		this.edit_time = edit_time;
	}
	
	@Column(name="edit_tick")
	public int getEdit_tick() {
		return edit_tick;
	}
	public void setEdit_tick(int edit_tick) {
		this.edit_tick = edit_tick;
	}
	
	@Column(name="role_name")
	public String getRole_name() {
		return role_name;
	}
	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}
	
	@Column(name="role_sex")
	public String getRole_sex() {
		return role_sex;
	}
	public void setRole_sex(String role_sex) {
		this.role_sex = role_sex;
	}
	
	@Column(name="role_age")
	public String getRole_age() {
		return role_age;
	}
	public void setRole_age(String role_age) {
		this.role_age = role_age;
	}
	
	@Column(name="role_race")
	public String getRole_race() {
		return role_race;
	}
	public void setRole_race(String role_race) {
		this.role_race = role_race;
	}
	
	@Column(name="role_country")
	public String getRole_country() {
		return role_country;
	}
	public void setRole_country(String role_country) {
		this.role_country = role_country;
	}

	@Column(name="role_introduction")
	public String getRole_introduction() {
		return role_introduction;
	}
	public void setRole_introduction(String role_introduction) {
		this.role_introduction = role_introduction;
	}
	
	@Column(name="role_at_movie")
	public String getRole_at_movie() {
		return role_at_movie;
	}
	public void setRole_at_movie(String role_at_movie) {
		this.role_at_movie = role_at_movie;
	}
	
	@Column(name="role_pic")
	public String getRole_pic() {
		return role_pic;
	}
	public void setRole_pic(String role_pic) {
		this.role_pic = role_pic;
	}
	
	@Column(name="role_profession")
	public String getRole_profession() {
		return role_profession;
	}
	public void setRole_profession(String role_profession) {
		this.role_profession = role_profession;
	}
	
	@Column(name="movie_id")
	public int getMovie_id() {
		return movie_id;
	}
	public void setMovie_id(int movie_id) {
		this.movie_id = movie_id;
	}
	
	@Column(name="actor")
	public String getActor() {
		return actor;
	}
	public void setActor(String actor) {
		this.actor = actor;
	}
	
	@Column(name="label")
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public int getAbsolute_id() {
		return absolute_id;
	}
	public void setAbsolute_id(int absolute_id) {
		this.absolute_id = absolute_id;
	}
	
}
