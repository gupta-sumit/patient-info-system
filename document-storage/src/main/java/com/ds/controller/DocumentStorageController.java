package com.ds.controller;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ds.domain.Document;
import com.ds.domain.UserPermission;
import com.ds.dto.DocumentUploadRequest;
import com.ds.dto.DocumentUploadResponse;
import com.ds.services.AccessManagerService;
import com.ds.services.DocumentService;

@RestController
@RequestMapping("/document")
public class DocumentStorageController {

	@Autowired
	private DocumentService documentService;
	
	@Autowired
	private AccessManagerService accessManagerService;
	
	@PostMapping("/upload")
	public DocumentUploadResponse uploadDocuments(@RequestParam("file") MultipartFile multipartFile, 
			@RequestParam("userId") String userId,
			@RequestParam("appId") String appId) {
		DocumentUploadRequest uploadRequest = new DocumentUploadRequest();
		uploadRequest.setApplicationId(appId);
		uploadRequest.setUserId(userId);
		uploadRequest.setMultipartFile(multipartFile);
		Document document = documentService.save(uploadRequest);
		return new DocumentUploadResponse(document.getDocumentId());
	}
	
	@GetMapping("/fetch/{documentId}/{accessKey}/{userId}")
	@ResponseBody
	public ResponseEntity<Resource> getDocument(@PathVariable("documentId") String documentId, @PathVariable("accessKey") String accessKey,
							@PathVariable("userId") String userId) {
		if(StringUtils.isEmpty(accessKey)) {
			throw new FobiddenAccessException();
		}
		UserPermission userPermission = accessManagerService.getUserPermission(accessKey, userId);
		if(userPermission == null) {
			throw new FobiddenAccessException();
		} 
		return documentService.fetchByDocumentId(documentId, (d,r) -> {
			return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
	                "attachment; filename=\"" + d.getMetadata().getFileName() + "\"").body(r);
		});
		
	}
	
}
