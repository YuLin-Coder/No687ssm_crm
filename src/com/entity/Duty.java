package com.entity;

import com.util.VeDate;

public class Duty {
	private String dutyid = "D" + VeDate.getStringId();
	private String dutyname;
	private String details;

	public String getDutyid() {
		return dutyid;
	}

	public void setDutyid(String dutyid) {
		this.dutyid = dutyid;
	}

	public String getDutyname() {
		return this.dutyname;
	}

	public void setDutyname(String dutyname) {
		this.dutyname = dutyname;
	}

	public String getDetails() {
		return this.details;
	}

	public void setDetails(String details) {
		this.details = details;
	}
}
