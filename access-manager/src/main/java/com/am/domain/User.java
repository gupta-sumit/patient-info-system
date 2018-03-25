package com.am.domain;

public class User {

	private String userId;
	private String emailId;
	
	public User() {}
	
	public User(String userId2) {
		this.userId = userId2;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
}
