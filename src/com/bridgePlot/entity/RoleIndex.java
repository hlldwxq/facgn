package com.bridgePlot.entity;

public class RoleIndex {
	
	private String image;
	private String type;
	private String name;
	private String url;
	
	public RoleIndex(){	
	}
	
	public RoleIndex(String image,String type,String name,String url){
		this.image = image;
		this.type = type;
		this.name = name;
		this.url = url;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
}
