package com.entity;

import com.util.VeDate;

public class Schedule {
	private String scheduleid = "S" + VeDate.getStringId();
	private String schedulename;
	private String details;

	public String getScheduleid() {
		return scheduleid;
	}

	public void setScheduleid(String scheduleid) {
		this.scheduleid = scheduleid;
	}

	public String getSchedulename() {
		return this.schedulename;
	}

	public void setSchedulename(String schedulename) {
		this.schedulename = schedulename;
	}

	public String getDetails() {
		return this.details;
	}

	public void setDetails(String details) {
		this.details = details;
	}
}
