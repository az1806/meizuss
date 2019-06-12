package com.jiaju.entity;

public class Company {
	private int companyid;
	private String companyname;
	private String syjs;
	private String gyjs;
	private String culture;
	private String address;
	private String email;
	private String contact;
	
	private String imgzong;
	private String www;
	private String cimg;
	private String logo;
	
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	public String getCimg() {
		return cimg;
	}
	public void setCimg(String cimg) {
		this.cimg = cimg;
	}
	public String getWww() {
		return www;
	}
	public void setWww(String www) {
		this.www = www;
	}
	public int getCompanyid() {
		return companyid;
	}
	public void setCompanyid(int companyid) {
		this.companyid = companyid;
	}
	public String getCompanyname() {
		return companyname;
	}
	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}
	public String getSyjs() {
		return syjs;
	}
	public void setSyjs(String syjs) {
		this.syjs = syjs;
	}
	public String getGyjs() {
		return gyjs;
	}
	
	public void setGyjs(String gyjs) {
		this.gyjs = gyjs;
	}
	public String getCulture() {
		return culture;
	}
	public void setCulture(String culture) {
		this.culture = culture;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	
	public String getImgzong() {
		return imgzong;
	}
	public void setImgzong(String imgzong) {
		this.imgzong = imgzong;
	}
	
	public Company() {
		
	}
	@Override
	public String toString() {
		return "Company [companyid=" + companyid + ", companyname="
				+ companyname + ", syjs=" + syjs + ", gyjs=" + gyjs
				+ ", culture=" + culture + ", address=" + address + ", email="
				+ email + ", contact=" + contact + ", imgzong=" + imgzong
				+ ", www=" + www + ", cimg=" + cimg + ", logo=" + logo + "]";
	}
	
	public Company(int companyid, String companyname, String syjs, String gyjs,
			String culture, String address, String email, String contact,
			String imgzong, String www, String cimg, String logo) {
		super();
		this.companyid = companyid;
		this.companyname = companyname;
		this.syjs = syjs;
		this.gyjs = gyjs;
		this.culture = culture;
		this.address = address;
		this.email = email;
		this.contact = contact;
		this.imgzong = imgzong;
		this.www = www;
		this.cimg = cimg;
		this.logo = logo;
	}


	
	
}
