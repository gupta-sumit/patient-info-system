package com.ds.services.impl;

import java.util.Date;
import java.util.Optional;
import java.util.function.BiFunction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import com.ds.domain.Document;
import com.ds.domain.User;
import com.ds.dto.DocumentUploadRequest;
import com.ds.repositories.DocumentRepository;
import com.ds.services.DocumentDetails;
import com.ds.services.DocumentService;
import com.ds.services.DocumentStoreService;

@Service
public class DocumentServiceImpl implements DocumentService {

	@Autowired
	private DocumentStoreService documentStoreService;
	
	@Autowired
	private DocumentRepository documentRepository;
	
	@Override
	public Document save(DocumentUploadRequest uploadRequest) {
		DocumentDetails documentDetails = documentStoreService.store(uploadRequest);
		Document document = prepareDocument(uploadRequest, documentDetails);
		return documentRepository.save(document);
	}

	private Document prepareDocument(DocumentUploadRequest uploadRequest, DocumentDetails documentDetails) {
		Document document = new Document();
		document.setAppId(uploadRequest.getApplicationId());
		document.setStorageDetails(documentDetails.getStorageInfo());
		document.setCreatedDate(new Date());
		document.setOwner(User.fromUserId(uploadRequest.getUserId()));
		document.setMetadata(documentDetails.getDocumentMetadata());
		return document;
	}

	@Override
	public <R> R fetchByDocumentId(String documentId, BiFunction<Document, Resource, R> function) {
		Optional<Document> documentOpt = documentRepository.findById(documentId);
		if(documentOpt.isPresent()) {
			Document document = documentOpt.get();
			Resource resource = documentStoreService.fetch(document.getStorageDetails().getPath());
			return function.apply(document, resource);
		} else {
			throw new ResourceNotFoundException("Document not found with id " + documentId);
		}
	}

}
