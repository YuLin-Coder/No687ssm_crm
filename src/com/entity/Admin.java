package com.entity;

import com.util.VeDate;

public class Admin {
	private String adminid = "A" + VeDate.getStringId();
	private String username;
	private String password;
	private String realname;
	private String sex;
	private String birthday;
	private String tel;
	private String qq;
	private String wechat;
	private String dutyid;
	private String addtime;
	private String dutyname;

	public String getAdminid() {
		return adminid;
	}

	public void setAdminid(String adminid) {
		this.adminid = adminid;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRealname() {
		return this.realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getBirthday() {
		return this.birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getTel() {
		return this.tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getQq() {
		return this.qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getWechat() {
		return this.wechat;
	}

	public void setWechat(String wechat) {
		this.wechat = wechat;
	}

	public String getDutyid() {
		return this.dutyid;
	}

	public void setDutyid(String dutyid) {
		this.dutyid = dutyid;
	}

	public String getAddtime() {
		return this.addtime;
	}

	public void setAddtime(String addtime) {
		this.addtime = addtime;
	}

	public String getDutyname() {
		return this.dutyname;
	}

	public void setDutyname(String dutyname) {
		this.dutyname = dutyname;
	}
}
