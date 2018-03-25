package com.ds.file.utils;

import java.io.File;
import java.io.IOException;
import java.util.function.Supplier;

import org.springframework.web.multipart.MultipartFile;

public class MultipartFileUtils {

	
	public static String fileName(MultipartFile multipartFile) {
		return multipartFile.getOriginalFilename();
	}
	
	public static File saveFile(MultipartFile multipartFile, Supplier<String> fileNameSupplier) throws IllegalStateException, IOException {
		File file = new File(fileNameSupplier.get());
		File parentDirFile = new File(file.getParent());
		if(!parentDirFile.exists()) {
			parentDirFile.mkdirs();
		}
		multipartFile.transferTo(file);
		return file;
	}
	
	
	
}
