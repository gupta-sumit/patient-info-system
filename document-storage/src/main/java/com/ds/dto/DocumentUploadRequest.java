package com.ds.dto;

import org.springframework.web.multipart.MultipartFile;

public class DocumentUploadRequest {

	// Assuming I will get verified userId using OAuth 
	private String userId;
	private MultipartFile multipartFile;
	private String applicationId;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public MultipartFile getMultipartFile() {
		return multipartFile;
	}

	public void setMultipartFile(MultipartFile multipartFile) {
		this.multipartFile = multipartFile;
	}

	public String getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(String applicationId) {
		this.applicationId = applicationId;
	}
	
}
