package com.bridgePlot.entity;

public class PlotIndex {
	private String img;
	private String type;
	private String name;
	private String url;
	
	public PlotIndex(){	
	}
	
	public PlotIndex(String img,String type,String name,String url){
		this.img = img;
		this.type = type;
		this.name = name;
		this.url = url;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
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
