package com.entity;

import com.util.VeDate;

public class Sercate {
	private String sercateid = "S" + VeDate.getStringId();
	private String cercatename;
	private String details;

	public String getSercateid() {
		return sercateid;
	}

	public void setSercateid(String sercateid) {
		this.sercateid = sercateid;
	}

	public String getCercatename() {
		return this.cercatename;
	}

	public void setCercatename(String cercatename) {
		this.cercatename = cercatename;
	}

	public String getDetails() {
		return this.details;
	}

	public void setDetails(String details) {
		this.details = details;
	}
}
