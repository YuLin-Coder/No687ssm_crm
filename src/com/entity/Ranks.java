package com.entity;

import com.util.VeDate;

public class Ranks {
	private String ranksid = "R" + VeDate.getStringId();
	private String ranksname;
	private String details;

	public String getRanksid() {
		return ranksid;
	}

	public void setRanksid(String ranksid) {
		this.ranksid = ranksid;
	}

	public String getRanksname() {
		return this.ranksname;
	}

	public void setRanksname(String ranksname) {
		this.ranksname = ranksname;
	}

	public String getDetails() {
		return this.details;
	}

	public void setDetails(String details) {
		this.details = details;
	}
}
