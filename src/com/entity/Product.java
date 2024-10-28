package com.entity;

import com.util.VeDate;

public class Product {
	private String productid = "P" + VeDate.getStringId();
	private String procateid;
	private String productname;
	private String details;
	private String price;
	private String inventory;
	private String num;
	private String memo;
	private String procatename;

	public String getProductid() {
		return productid;
	}

	public void setProductid(String productid) {
		this.productid = productid;
	}

	public String getProcateid() {
		return this.procateid;
	}

	public void setProcateid(String procateid) {
		this.procateid = procateid;
	}

	public String getProductname() {
		return this.productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public String getDetails() {
		return this.details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public String getPrice() {
		return this.price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getInventory() {
		return this.inventory;
	}

	public void setInventory(String inventory) {
		this.inventory = inventory;
	}

	public String getNum() {
		return this.num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getMemo() {
		return this.memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getProcatename() {
		return this.procatename;
	}

	public void setProcatename(String procatename) {
		this.procatename = procatename;
	}
}
