package com.ds.domain;

public class User {

	private String userId;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public static User fromUserId(String userId) {
		User user = new User();
		user.userId = userId;
		return user;
	}
}
