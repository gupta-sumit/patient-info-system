package com.ds.services.impl;

import java.io.File;

import org.springframework.stereotype.Service;

import com.ds.domain.DocumentMetadata;
import com.ds.services.DocumentMetadataExtractor;

@Service
public class BasicMetadataExtractor implements DocumentMetadataExtractor {

	@Override
	public DocumentMetadata extractMetadata(File file) {
		DocumentMetadata metadata = new DocumentMetadata();
		metadata.setFileName(file.getName());
		metadata.setSize(file.length());
		return metadata;
	}

}
