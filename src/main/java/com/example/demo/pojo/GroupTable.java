package com.example.demo.pojo;

import java.util.Date;

public class GroupTable  {
	

	private String msg;
	
	private Date time;
	private String loginName;
	private String wechatId;
	private String avatar;
	private Integer text;
	
	
	
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	
	public String getLoginName() {
		return loginName;
	}
	
	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	
	
	public String getWechatId() {
		return wechatId;
	}

	public void setWechatId(String wechatId) {
		this.wechatId = wechatId;
	}
	
	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}
	
	public Integer getText() {
		return text;
	}

	public void setText(Integer text) {
		this.text = text;
	}
	


}