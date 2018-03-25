package com.ds.services.impl;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import com.ds.config.DocumentStoreConfig;
import com.ds.domain.DocumentMetadata;
import com.ds.domain.StorageInfo;
import com.ds.dto.DocumentUploadRequest;
import com.ds.file.utils.MultipartFileUtils;
import com.ds.services.DocumentDetails;
import com.ds.services.DocumentMetadataExtractor;
import com.ds.services.DocumentSaveException;
import com.ds.services.DocumentStoreService;

@Service
public class DocumentDiskStoreServiceImpl implements DocumentStoreService {

	private static final String FILE_SEPARATOR = "/";
	
	// Assuming just one document type or else have factory here
	@Autowired
	private DocumentMetadataExtractor metadataExtractor;
	
	@Autowired
	private DocumentStoreConfig documentStoreConfig;
	
	@Override
	public DocumentDetails store(DocumentUploadRequest uploadRequest) {
		try {
			String fileName = System.nanoTime() + "-" + MultipartFileUtils.fileName(uploadRequest.getMultipartFile());
			String fileRelativePath = getRelativePath(uploadRequest.getUserId(), fileName);
			File savedFile = MultipartFileUtils.saveFile(uploadRequest.getMultipartFile(), () -> getAbsolutePath(fileRelativePath));
			DocumentMetadata documentMetadata = metadataExtractor.extractMetadata(savedFile);
			return new DocumentDetails(new StorageInfo(fileRelativePath),documentMetadata);
		} catch (IllegalStateException | IOException e) {
			throw new DocumentSaveException("Error while writing document ", e);
		}
	}

	@Override
	public Resource fetch(String relativePath) {
		String absolutePath = documentStoreConfig.getHomeDirectory() + FILE_SEPARATOR + relativePath;
		FileSystemResource fileSystemResource = new FileSystemResource(absolutePath);
		return fileSystemResource;
	}

	private String getAbsolutePath(String relativePath) {
		String homeDir = documentStoreConfig.getHomeDirectory();
		return homeDir + FILE_SEPARATOR + relativePath;
	}

	private String getRelativePath(String userId, String fileName) {
		String directoryForUser = documentStoreConfig.getDirectoryForUser(userId);
		return directoryForUser + FILE_SEPARATOR + fileName;
	}
	
}
