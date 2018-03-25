package com.ds.services;

import com.ds.domain.DocumentMetadata;
import com.ds.domain.StorageInfo;

public class DocumentDetails {

	private DocumentMetadata documentMetadata;
	private StorageInfo storageInfo;
	
	public DocumentDetails(StorageInfo storageInfo2, DocumentMetadata documentMetadata2) {
		this.documentMetadata = documentMetadata2;
		this.storageInfo = storageInfo2;
	}
	public DocumentMetadata getDocumentMetadata() {
		return documentMetadata;
	}
	public void setDocumentMetadata(DocumentMetadata documentMetadata) {
		this.documentMetadata = documentMetadata;
	}
	public StorageInfo getStorageInfo() {
		return storageInfo;
	}
	public void setStorageInfo(StorageInfo storageInfo) {
		this.storageInfo = storageInfo;
	}
	
	
}
