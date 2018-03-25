package com.am.domain;

import java.util.Date;

import org.springframework.data.annotation.Id;

public class AccessRequest {

	@Id
	private String requestId;
	private String accessTokenId;
	private Permission requestedPermission;
	private String requestedUserId;
	private String approverId;
	private Date requestedDate;
	private RequestStatus requestStatus;
	private Date lastUpdatedDate;
	
	public enum RequestStatus {
		APPROVED, REJECTED, PENDING
	}

	public Date getRequestedDate() {
		return requestedDate;
	}

	public void setRequestedDate(Date requestedDate) {
		this.requestedDate = requestedDate;
	}

	public RequestStatus getRequestStatus() {
		return requestStatus;
	}

	public void setRequestStatus(RequestStatus requestStatus) {
		this.requestStatus = requestStatus;
	}

	public Date getLastUpdatedDate() {
		return lastUpdatedDate;
	}

	public void setLastUpdatedDate(Date lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}

	public String getRequestId() {
		return requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	public String getAccessTokenId() {
		return accessTokenId;
	}

	public void setAccessTokenId(String accessTokenId) {
		this.accessTokenId = accessTokenId;
	}

	public Permission getRequestedPermission() {
		return requestedPermission;
	}

	public void setRequestedPermission(Permission requestedPermission) {
		this.requestedPermission = requestedPermission;
	}

	public String getRequestedUserId() {
		return requestedUserId;
	}

	public void setRequestedUserId(String requestedUserId) {
		this.requestedUserId = requestedUserId;
	}

	public String getApproverId() {
		return approverId;
	}

	public void setApproverId(String approverId) {
		this.approverId = approverId;
	}
	
	
}
