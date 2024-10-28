package com.entity;

import com.util.VeDate;

public class Serve {
	private String serveid = "S" + VeDate.getStringId();
	private String sercateid;
	private String productid;
	private String customerid;
	private String adminid;
	private String content;
	private String conclusion;
	private String memo;
	private String cercatename;
	private String productname;
	private String realname;
	private String username;

	public String getServeid() {
		return serveid;
	}

	public void setServeid(String serveid) {
		this.serveid = serveid;
	}

	public String getSercateid() {
		return this.sercateid;
	}

	public void setSercateid(String sercateid) {
		this.sercateid = sercateid;
	}

	public String getProductid() {
		return this.productid;
	}

	public void setProductid(String productid) {
		this.productid = productid;
	}

	public String getCustomerid() {
		return this.customerid;
	}

	public void setCustomerid(String customerid) {
		this.customerid = customerid;
	}

	public String getAdminid() {
		return this.adminid;
	}

	public void setAdminid(String adminid) {
		this.adminid = adminid;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getConclusion() {
		return this.conclusion;
	}

	public void setConclusion(String conclusion) {
		this.conclusion = conclusion;
	}

	public String getMemo() {
		return this.memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getCercatename() {
		return this.cercatename;
	}

	public void setCercatename(String cercatename) {
		this.cercatename = cercatename;
	}

	public String getProductname() {
		return this.productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public String getRealname() {
		return this.realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}
