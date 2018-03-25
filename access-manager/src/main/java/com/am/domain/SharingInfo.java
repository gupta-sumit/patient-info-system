package com.am.domain;

import java.util.Date;

public class SharingInfo {

	private String userId;
	private Permission grantedPermission;
	private Date grantedDate;
	
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
	public Date getGrantedDate() {
		return grantedDate;
	}
	public void setGrantedDate(Date grantedDate) {
		this.grantedDate = grantedDate;
	}
	public static SharingInfo from(String userId2, Permission permission) {
		SharingInfo si = new SharingInfo();
		si.setUserId(userId2);
		si.setGrantedPermission(permission);
		si.setGrantedDate(new Date());
		return si;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SharingInfo other = (SharingInfo) obj;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}
	
	
	
}
