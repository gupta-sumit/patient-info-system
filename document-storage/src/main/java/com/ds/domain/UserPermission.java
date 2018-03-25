package com.ds.domain;

public class UserPermission {

	private String userId;
	private Permission grantedPermission;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Permission getGrantedPermission() {
		return grantedPermission;
	}
	public void setGrantedPermission(Permission grantedPermission) {
		this.grantedPermission = grantedPermission;
	}
	
}
