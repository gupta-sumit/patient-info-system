package com.ds.domain;

import java.util.Date;

import org.springframework.data.annotation.Id;

public class Document {

	@Id
	private String documentId;
	private String appId;
	private User owner;
	private StorageInfo storageDetails;
	private DocumentMetadata metadata;
	private Date createdDate;
	
	public String getDocumentId() {
		return documentId;
	}
	public void setDocumentId(String documentId) {
		this.documentId = documentId;
	}
	public String getAppId() {
		return appId;
	}
	public void setAppId(String appId) {
		this.appId = appId;
	}
	public User getOwner() {
		return owner;
	}
	public void setOwner(User owner) {
		this.owner = owner;
	}
	public StorageInfo getStorageDetails() {
		return storageDetails;
	}
	public void setStorageDetails(StorageInfo storageDetails) {
		this.storageDetails = storageDetails;
	}
	public DocumentMetadata getMetadata() {
		return metadata;
	}
	public void setMetadata(DocumentMetadata metadata) {
		this.metadata = metadata;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	
}
