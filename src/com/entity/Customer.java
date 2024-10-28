package com.entity;

import com.util.VeDate;

public class Customer {
	private String customerid = "C" + VeDate.getStringId();
	private String realname;
	private String nickname;
	private String tel;
	private String qq;
	private String wechat;
	private String sex;
	private String birthday;
	private String custypeid;
	private String soureid;
	private String addtime;
	private String adminid;
	private String expenseid;
	private String integral;
	private String ranksid;
	private String ranksname;
	private String scheduleid;
	private String schedulename;
	private String plan;
	private String serveid;
	private String memo;
	private String sourename;
	private String username;

	public String getCustomerid() {
		return customerid;
	}

	public void setCustomerid(String customerid) {
		this.customerid = customerid;
	}

	public String getRealname() {
		return this.realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public String getNickname() {
		return this.nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
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

	public String getCustypeid() {
		return this.custypeid;
	}

	public void setCustypeid(String custypeid) {
		this.custypeid = custypeid;
	}

	public String getSoureid() {
		return this.soureid;
	}

	public void setSoureid(String soureid) {
		this.soureid = soureid;
	}

	public String getAddtime() {
		return this.addtime;
	}

	public void setAddtime(String addtime) {
		this.addtime = addtime;
	}

	public String getAdminid() {
		return this.adminid;
	}

	public void setAdminid(String adminid) {
		this.adminid = adminid;
	}

	public String getExpenseid() {
		return this.expenseid;
	}

	public void setExpenseid(String expenseid) {
		this.expenseid = expenseid;
	}

	public String getIntegral() {
		return this.integral;
	}

	public void setIntegral(String integral) {
		this.integral = integral;
	}

	public String getRanksid() {
		return this.ranksid;
	}

	public void setRanksid(String ranksid) {
		this.ranksid = ranksid;
	}

	public String getScheduleid() {
		return this.scheduleid;
	}

	public void setScheduleid(String scheduleid) {
		this.scheduleid = scheduleid;
	}

	public String getPlan() {
		return this.plan;
	}

	public void setPlan(String plan) {
		this.plan = plan;
	}

	public String getServeid() {
		return this.serveid;
	}

	public void setServeid(String serveid) {
		this.serveid = serveid;
	}

	public String getMemo() {
		return this.memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getSourename() {
		return this.sourename;
	}

	public void setSourename(String sourename) {
		this.sourename = sourename;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getRanksname() {
		return ranksname;
	}

	public String getSchedulename() {
		return schedulename;
	}

	public void setRanksname(String ranksname) {
		this.ranksname = ranksname;
	}

	public void setSchedulename(String schedulename) {
		this.schedulename = schedulename;
	}
}
