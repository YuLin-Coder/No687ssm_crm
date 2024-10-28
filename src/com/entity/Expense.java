package com.entity;

import com.util.VeDate;

public class Expense {
	private String expenseid = "S" + VeDate.getStringId();
	private String adminid;
	private String username;
	private String customerid;
	private String realname;
	private String price;
	private String num;
	private String integral;
	private String paywayid;
	private String wayname;
	private String memo;
	private String productid;
	private String productname;

	public String getExpenseid() {
		return expenseid;
	}

	public String getAdminid() {
		return adminid;
	}

	public String getUsername() {
		return username;
	}

	public String getCustomerid() {
		return customerid;
	}

	public String getRealname() {
		return realname;
	}

	public String getPrice() {
		return price;
	}

	public String getNum() {
		return num;
	}

	public String getIntegral() {
		return integral;
	}

	public String getPaywayid() {
		return paywayid;
	}

	public String getWayname() {
		return wayname;
	}

	public void setExpenseid(String expenseid) {
		this.expenseid = expenseid;
	}

	public void setAdminid(String adminid) {
		this.adminid = adminid;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setCustomerid(String customerid) {
		this.customerid = customerid;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public void setIntegral(String integral) {
		this.integral = integral;
	}

	public void setPaywayid(String paywayid) {
		this.paywayid = paywayid;
	}

	public void setWayname(String wayname) {
		this.wayname = wayname;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getProductid() {
		return productid;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductid(String productid) {
		this.productid = productid;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

}
