package com.ds.services;

import com.ds.dto.DocumentUploadRequest;

public interface DocumentStoreService {

	public DocumentDetails store(DocumentUploadRequest uploadRequest) throws DocumentSaveException;
	
	public org.springframework.core.io.Resource fetch(String filePath);
	
}
