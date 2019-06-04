package com.jiaju.entity;

public class Banners {

	private int id;
	private int cpid;
	public int getCpid() {
		return cpid;
	}
	public void setCpid(int cpid) {
		this.cpid = cpid;
	}
	private String banner;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBanner() {
		return banner;
	}
	public void setBanner(String banner) {
		this.banner = banner;
	}
	
	
	public Banners(int cpid, int id, String banner) {
		super();
		this.cpid=cpid;
		this.id = id;
		this.banner = banner;
	}
	public Banners() {
		super();
	}
	
	
}
