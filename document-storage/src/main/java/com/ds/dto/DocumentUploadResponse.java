package com.ds.dto;

public class DocumentUploadResponse {

	private String documentId;

	public DocumentUploadResponse(String documentId) {
		this.documentId = documentId;
	}
	
	public String getDocumentId() {
		return documentId;
	}

	public void setDocumentId(String documentId) {
		this.documentId = documentId;
	} 
	
}
