package com.am.domain;

import java.util.Date;
import java.util.Set;

import org.springframework.data.annotation.Id;

public class ResourceAccessConfig {

	@Id
	private String resourceId;
	private String documentId;
	private String documentType;
	private String appServiceName;
	private Set<SharingInfo> sharedWith;
	private Date createdDate;
	private User ownerInfo;
	
	
	
	
	public String getResourceId() {
		return resourceId;
	}
	public void setResourceId(String resourceId) {
		this.resourceId = resourceId;
	}
	public String getDocumentId() {
		return documentId;
	}
	public void setDocumentId(String documentId) {
		this.documentId = documentId;
	}
	
	
	public Set<SharingInfo> getSharedWith() {
		return sharedWith;
	}
	public void setSharedWith(Set<SharingInfo> sharedWith) {
		this.sharedWith = sharedWith;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public User getOwnerInfo() {
		return ownerInfo;
	}
	public void setOwnerInfo(User ownerInfo) {
		this.ownerInfo = ownerInfo;
	}
	public String getDocumentType() {
		return documentType;
	}
	public void setDocumentType(String documentType) {
		this.documentType = documentType;
	}
	public String getAppServiceName() {
		return appServiceName;
	}
	public void setAppServiceName(String appServiceName) {
		this.appServiceName = appServiceName;
	}
	
}
