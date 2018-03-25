package com.ds.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix="docstore")
public class DocumentStoreConfigImpl implements DocumentStoreConfig {

	private String documentStorageDirectory;
	private String documentHomeDirectory;
	
	public String getDocumentStorageDirectory() {
		return documentStorageDirectory;
	}

	public void setDocumentStorageDirectory(String documentStorageDirectory) {
		this.documentStorageDirectory = documentStorageDirectory;
	}
	
	public String getDirectoryForUser(String userId) {
		return String.format(documentStorageDirectory, userId);
	}

	@Override
	public String getHomeDirectory() {
		return documentHomeDirectory;
	}

	public String getDocumentHomeDirectory() {
		return documentHomeDirectory;
	}

	public void setDocumentHomeDirectory(String documentHomeDirectory) {
		this.documentHomeDirectory = documentHomeDirectory;
	}
	
}
