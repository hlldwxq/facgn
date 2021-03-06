package com.bridgePlot.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity  //h
@Table(name="plot")  //h
public class Plot {
	private int id;
	private int absolute_id;
	private String plot_name;
	private String label;
	private String plot_content;
	private int author_id;
	private String author;
	private Date edit_time;
	private int edit_tick;
	private String plot_pic;
	
	@Id
	@Column(name="id",nullable=false,unique=true)
	@GeneratedValue(strategy = GenerationType.IDENTITY) //h  
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name="plot_name")
	public String getPlot_name() {
		return plot_name;
	}
	public void setPlot_name(String plot_name) {
		this.plot_name = plot_name;
	}
	
	@Column(name="label")
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	
	@Column(name="plot_content")
	public String getPlot_content() {
		return plot_content;
	}
	public void setPlot_content(String plot_content) {
		this.plot_content = plot_content;
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
	
	@Column(name="plot_pic")
	public String getPlot_pic() {
		return plot_pic;
	}
	public void setPlot_pic(String plot_pic) {
		this.plot_pic = plot_pic;
	}
	
	@Column(name="absolute_id")
	public int getAbsolute_id() {
		return absolute_id;
	}
	public void setAbsolute_id(int absolute_id) {
		this.absolute_id = absolute_id;
	}

}
