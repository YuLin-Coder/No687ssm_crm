package com.entity;

import com.util.VeDate;

public class Soure {
	private String soureid = "S" + VeDate.getStringId();
	private String sourename;
	private String details;

	public String getSoureid() {
		return soureid;
	}

	public void setSoureid(String soureid) {
		this.soureid = soureid;
	}

	public String getSourename() {
		return this.sourename;
	}

	public void setSourename(String sourename) {
		this.sourename = sourename;
	}

	public String getDetails() {
		return this.details;
	}

	public void setDetails(String details) {
		this.details = details;
	}
}
