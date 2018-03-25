package com.ds.services;

import java.util.function.BiFunction;

import org.springframework.core.io.Resource;

import com.ds.domain.Document;
import com.ds.dto.DocumentUploadRequest;

public interface DocumentService {

	public Document save(DocumentUploadRequest uploadRequest);
	
	public <R> R fetchByDocumentId(String documentId,BiFunction<Document, Resource, R> function);
	
}

