package com.entity;

import com.util.VeDate;

public class Procate {
	private String procateid = "P" + VeDate.getStringId();
	private String procatename;
	private String details;

	public String getProcateid() {
		return procateid;
	}

	public void setProcateid(String procateid) {
		this.procateid = procateid;
	}

	public String getProcatename() {
		return this.procatename;
	}

	public void setProcatename(String procatename) {
		this.procatename = procatename;
	}

	public String getDetails() {
		return this.details;
	}

	public void setDetails(String details) {
		this.details = details;
	}
}
