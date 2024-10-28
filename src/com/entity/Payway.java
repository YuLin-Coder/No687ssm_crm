package com.entity;

import com.util.VeDate;

public class Payway {
	private String paywayid = "P" + VeDate.getStringId();
	private String wayname;
	private String payee;
	private String memo;

	public String getPaywayid() {
		return paywayid;
	}

	public void setPaywayid(String paywayid) {
		this.paywayid = paywayid;
	}

	public String getWayname() {
		return this.wayname;
	}

	public void setWayname(String wayname) {
		this.wayname = wayname;
	}

	public String getPayee() {
		return this.payee;
	}

	public void setPayee(String payee) {
		this.payee = payee;
	}

	public String getMemo() {
		return this.memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}
}
