package com.am.dto;

public class ResourceAccessConfigDTO {

	private String resourceId;
	private String userId;
	private String documentId;
	private String documentType;
	private String appServiceName;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getDocumentId() {
		return documentId;
	}
	public void setDocumentId(String documentId) {
		this.documentId = documentId;
	}
	public String getAppServiceName() {
		return appServiceName;
	}
	public void setAppServiceName(String appServiceName) {
		this.appServiceName = appServiceName;
	}
	public String getDocumentType() {
		return documentType;
	}
	public void setDocumentType(String documentType) {
		this.documentType = documentType;
	}
	public String getResourceId() {
		return resourceId;
	}
	public void setResourceId(String resourceId) {
		this.resourceId = resourceId;
	}
	@Override
	public String toString() {
		return "ResourceAccessConfigDTO [resourceId=" + resourceId + ", userId=" + userId + ", documentId=" + documentId
				+ ", documentType=" + documentType + ", appServiceName=" + appServiceName + "]";
	}
	
	
	
}
