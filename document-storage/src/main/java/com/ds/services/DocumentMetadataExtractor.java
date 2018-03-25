package com.ds.services;

import java.io.File;

import com.ds.domain.DocumentMetadata;

public interface DocumentMetadataExtractor {

	DocumentMetadata extractMetadata(File file);
	
}
